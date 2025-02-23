import java.util.*;
import java.io.*;

public class Main {
	static int[] par;
	static int[] height;
	static int n;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 초기 집합 개수
		int m = Integer.parseInt(st.nextToken()); // 연산 개수
		par = new int[n+1];
		height = new int[n+1];
		Arrays.fill(par, -1);
		Arrays.fill(height, 1);
		
		StringBuilder sb = new StringBuilder(); // 출력용
		
		for (int i=0;i<m;i++) { // 연산 시작
			st = new StringTokenizer(br.readLine());
			int sign = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (sign==0) merge(a, b);
			else if (find(a)==find(b)) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		System.out.print(sb);
	}
	
	public static int find(int k) {
		if(par[k]==-1) return k; // 최상위 부모 리턴
		return par[k] = find(par[k]);
	}
	
	public static void merge(int a, int b) {
		a = find(a);
		b = find(b);
		if (a==b) return;
		
		if(height[a]>height[b]) par[b] = a;
		else {
			par[a] = b;
			if(height[a]==height[b]) height[b]++;
		}
	}
}
