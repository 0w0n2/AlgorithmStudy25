import java.io.*;
import java.util.*;

public class Main {
	static int dp[] = new int[12];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int t = 0; t<tc; t++) sb.append(f(Integer.parseInt(br.readLine()))).append("\n");
		System.out.println(sb);
	}
	public static int f(int n) {
		if (n<=0) return 0;
		
		if (dp[n]!=0)return dp[n];
		
		dp[n] = f(n-1) + f(n-2) + f(n-3);
		
		return dp[n];
	}
}
