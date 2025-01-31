import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        int result = 0;
        int endTime = -1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = arr[i][1] - arr[i][0];           //사용시간 쓸려고 했는데 필요없는듯
        }

        Arrays.sort(arr, (a, b) -> a[1] != b[1] ?
                Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])); // 2차원배열 정렬
                                                     //1. 끝나는 시간 오름차순 -> 같으면 시작 시간 오름차순
        for(int i = 0; i < N ; i++) {
            if(endTime <= arr[i][0]) {
                endTime = arr[i][1];
                result++;
            }
        }
        System.out.println(result);
    }
}

