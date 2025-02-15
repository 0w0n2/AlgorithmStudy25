import java.io.*;
import java.util.*;

public class Main{
[2;2R[3;1R
[>77;30706;0c]10;rgb:bfbf/bfbf/bfbf]11;rgb:0000/0000/0000    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[N];


        if (N == 1) {
            System.out.println(arr[0]);
        }
        else if (N == 2) {
            System.out.println(arr[0] + arr[1]);
        }
        else if (N == 3) {
            System.out.println(Math.max(arr[1] +arr[2], arr[0] + arr[2]));
        } else {
            dp[0] = arr[0];
            dp[1] = arr[0] + arr[1];
            dp[2] = Math.max(arr[1] +arr[2], arr[0] + arr[2]);

            for(int i = 3 ; i < N ; i++) {
                // 점화식
                dp[i] += Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
            }

            System.out.println(dp[N-1]);
        }
    }
}
