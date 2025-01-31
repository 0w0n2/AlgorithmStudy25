import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for(int T=1; T <= testCase ; T++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int[] ZsortArr = new int[N];    // 지그재그로 놔둠
            int left = 0, right = N - 1;
            for (int i = 0; i < N; i++) {
                if(i % 2 == 0) {
                    ZsortArr[left++] = arr[i];
                } else {
                    ZsortArr[right--] = arr[i];
                }
            }

            int result = 0;
            for (int i = 1 ; i < N ; i++) {
                result = Math.max(result, Math.abs(ZsortArr[i] - ZsortArr[i-1]));
            }
            result = Math.max(result, Math.abs(ZsortArr[N-1] - ZsortArr[0]));

            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}

