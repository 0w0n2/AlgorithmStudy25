import java.util.*;
import java.io.*;

public class Math {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 수열의 길이
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[n];
        int [] dp = new int[n];
        for (int i=0;i<n;i++) { // O(n)
            arr[i] = Integer.parseInt(st.nextToken()); // 수열입력
            dp[i] = 1; // 자기 자신의 길이
        }
        // 가장 긴 감소하는 수열 찾기
        int result = 0;
        for (int i=0;i<n;i++){ // 기준 값, 기준값의 왼쪽에 증가하는 수열 찾음 // O(n)
            for (int j=0;j<i;j++){ // O(i)
                if(arr[j]>arr[i]){ 
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            result = Math.max(dp[i], result);
        }
        System.out.print(result);
    }
    // O(n^2)
}

