import java.util.*;
import java.io.*;

class Solution{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[T];
		int[] dp = new int[T];
		for(int i=0; i<T; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i]=1;
		}
		
		// dp배열
		for(int i=0;i<T;i++) {
			for(int j=0;j<i;j++) { // i가 항상 크게끔해서 비교
				if(arr[j] > arr[i]) { // 내림차순
					dp[i] = Math.max(dp[i], dp[j]+1); // 1올린것을 저장, 저장되있으면 max값(=결국 max값 계산)
				}
			}
		}
		
		//최대값 구하기
		int max_v = 0;
		for(int i=0;i<T;i++) max_v = Math.max(max_v, dp[i]);
		System.out.println(max_v);
	}
}
