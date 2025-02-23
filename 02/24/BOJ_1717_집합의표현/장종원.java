package test;

import java.io.*;
import java.util.*;

public class Solution_집합의표현 {

	static int N, M;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N + 1];
		for(int i = 1 ; i <= N ; i++) parents[i] = i;
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int check = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(check == 0) union(a, b);
			else {
				if(find(a) == find(b))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}
	
	
	
	public static void union(int a, int b) {
		
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA != rootB)
			parents[rootA] = rootB;
	}
	
	
	public static int find(int a) {
		
		if(parents[a] != a) {
			parents[a] = find(parents[a]);
		}
		return parents[a];
	}
}

