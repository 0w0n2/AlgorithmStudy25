import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arrX = new int[M];
        int[] arrY = new int[M];
        int meanX = 0;
        int meanY = 0;
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            arrX[i] = Integer.parseInt(st.nextToken());
            arrY[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrX);         // X, Y 정렬해서 중앙값구해가지고 뺌
        Arrays.sort(arrY);         // 개수가 짝수일땐 중앙값 두개의 평균이 더 최소값 나오지 않나 싶은데
        int result = 0;           // 평균으로하면 틀림

        for(int i = 0 ; i < M ; i++) {
            result += Math.abs(arrX[i] - arrX[M / 2]) + Math.abs(arrY[i] - arrY[M / 2]);
        }

        System.out.println(result);
    }
}

