package test;

import java.io.*;
import java.util.*;

public class Solution_1197_최소스패닝트리 {

	static int V, E ;
	static PriorityQueue<Node> pq = new PriorityQueue<>((e1, e2)-> e1.weight - e2.weight);
	static int[] parents;
	static class Node {
		int to, from;
		int weight;
		
		Node(int to, int from, int weight) {
			this.to = to;
			this.from = from;
			this.weight =weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parents = new int[V + 1];
		for(int i = 1; i <= V ; i++) parents[i] = i;
		
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			pq.add(new Node(to, from, weight));
		}
		
		System.out.println(MST());
	}
	
	public static int MST() {
		
		int cost = 0;
		int unionCnt = 0;
		
		while(!pq.isEmpty()) {
			
			Node node = pq.poll();
			
			if(union(node.to, node.from)) {
				
				cost += node.weight;
				unionCnt++;
				
				if(unionCnt == V -1) return cost;
			}
		}
		return -1;
	}
	public static boolean union(int a , int b) {		
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) return false;
		
		parents[rootA] = rootB;
		return true;
	}
	
	public static int find(int a) {
		if(parents[a] != a) {
			parents[a] = find(parents[a]);
		}
		return parents[a];
	}
}

