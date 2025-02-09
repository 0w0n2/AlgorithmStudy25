import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];

        for(int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int red = arr[0][0];
        int green = arr[0][1];
        int blue = arr[0][2];
        //메모리 최대한 줄여봤는데 시간 많이 안줄어드네 + 메모리

        for (int i = 1; i < N; i++) {
            int newRed = arr[i][0] + Math.min(green, blue);
            int newGreen = arr[i][1] + Math.min(red, blue);
            int newBlue = arr[i][2] + Math.min(red, green);

            red = newRed;
            green = newGreen;
            blue = newBlue;
        }

        int result = Math.min(red, Math.min(green, blue));

        System.out.println(result);
    }
}

