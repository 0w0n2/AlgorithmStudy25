package test;

import java.io.*;
import java.util.*;

public class Solution_10775_공항 {
	
	static int G, P;
	static int[] parents;
	static int[] arr;
			
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		G = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		
		arr = new int[P];
		parents = new int[G + 1];
		for(int i = 1 ; i <= G ; i++)
			parents[i] = i;
		
		int result = 0;
		for(int i = 0; i < P ; i++) {
			int g = Integer.parseInt(br.readLine());
			int gate = find(g);
			
			if(gate == 0)
				break;
			
			result++;
			union(gate, gate - 1);
		}
		
		System.out.println(result);
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

