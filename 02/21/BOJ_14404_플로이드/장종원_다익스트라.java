package pratice221;

import java.io.*;
import java.util.*;

public class Solution_11404_플로이드 {

	static int V, E;
	static List<List<Node>> graph;
	static int[] cost;
	static boolean[] check;
	static PriorityQueue<Node> pq = new PriorityQueue<>((e1, e2)-> e1.weight - e2.weight);
	
	static class Node{
		int node;
		int weight;
		
		Node(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for(int i = 0; i <= V; i++) graph.add(new ArrayList<>());
		
		
		for(int i = 0; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b, w));
		}
		
		for(int i = 1 ; i <= V ; i++) {
			cost = new int[V + 1];
			check = new boolean[V + 1];
			Arrays.fill(cost,  Integer.MAX_VALUE);
			
			dijkstra(i);
			
			for(int j = 1; j <= V ; j++) {
				if(j == V) {
					if (cost[j] == Integer.MAX_VALUE)
						System.out.print(0);
					else
						System.out.print(cost[j]);
				}
				else {
					if (cost[j] == Integer.MAX_VALUE)
						System.out.print(0 + " ");
					else
						System.out.print(cost[j] + " ");
				}
			}
			System.out.println();
		}
	}
	
	public static void dijkstra(int start) {
		pq.offer(new Node(start, 0));
		cost[start] = 0;
		
		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.node;
			
			if(check[cur]) continue;
			check[cur] = true;
			
			for (Node node : graph.get(cur)) {
				if (!check[node.node] && cost[node.node] > cost[cur] + node.weight) {
					cost[node.node] = cost[cur] + node.weight;
					pq.add(new Node(node.node, cost[node.node]));
				}
			}
		}			
	}
}
