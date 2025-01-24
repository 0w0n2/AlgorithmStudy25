import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] t = new int[n + 1];
		int[] p = new int[n + 1];
		int[] dp = new int[n + 2]; // 배열 인덱스 초과때문에 늘림
		
		for(int i=1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = n; i > 0; i--) {
			int next_day = i + t[i];  // 해당 날에 일을 시작한다면 종료 일
			
			if(next_day > n + 1) {
				dp[i] = dp[i + 1];
			} else {
				dp[i] = Math.max(dp[i + 1], p[i] + dp[next_day]);  // 점화식
			}
		}
		System.out.println(dp[1]);
	}
}
