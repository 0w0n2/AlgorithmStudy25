package test;

import java.io.*;
import java.util.*;

public class Solution_1766_문제집 {
	
	static int N, M;
	static int[] edgeCnt;
	static List<Integer>[] graph;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		edgeCnt = new int[N + 1];
		graph = new List[N + 1];
		for(int i = 0 ; i <= N ; i++)
			graph[i] = new ArrayList<>();
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			edgeCnt[b]++;
		}
		
		sort();
		System.out.println(sb);
	}
	
	public static void sort() {
		PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2)-> e1 - e2);
//		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= N ; i++) {
			if(edgeCnt[i] == 0) pq.offer(i);
		}
		
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			
			sb.append(cur).append(" ");
			
			for(int next : graph[cur]) {
				
				if(--edgeCnt[next] == 0) pq.offer(next);
			}
		}
	}
}

