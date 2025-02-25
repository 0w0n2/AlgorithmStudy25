package coding;

import java.io.*;
import java.util.*;

public class Solution_2887_행성터널 {
	
	// 걍 우선순위 큐 써서 서로소 뽑으면 되는거 아님..?
	
	static int N;
	static int[] parents;
	static PriorityQueue<Planet> pq = new PriorityQueue<>((e1, e2)-> e1.weight -e2.weight);
	static int[][] arr;
	
	static class Planet {
		int to, from;
		int weight;
		
		Planet(int to, int from, int weight) {
			this.to = to;
			this.from = from;
			this.weight = weight;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		parents = new int[N + 1];
		for(int i = 1 ; i <= N ; i++) 
			parents[i] = i;
		
		arr = new int[N][3]; 
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		makEdges(0);
		makEdges(1);
		makEdges(2);
		
		
		System.out.println(MST());
	}
	
	public static void makEdges(int dimension) {
		List<Planet> edges = new ArrayList<>();
		
		for(int i = 0; i < N ; i++) {
			edges.add(new Planet(i + 1, -1, arr[i][dimension]));
		}
		
		Collections.sort(edges, (p1, p2) -> p1.weight - p2.weight);
		
		for (int i = 0; i < N - 1 ; i++) {
			Planet edge = new Planet(edges.get(i).to, edges.get(i + 1).to, Math.abs(edges.get(i).weight - edges.get(i+1).weight));
			pq.add(edge);
		}
	}
	
	public static int MST() {
		
		int cost = 0;
		int unionCnt = 0;
		
		while(!pq.isEmpty()) {
			Planet planet = pq.poll();
			
			if(union(planet.to, planet.from)) {
				
				cost += planet.weight;
				unionCnt++;
				
				if(unionCnt == N - 1) return cost;
			}
		}
		
		return -1;
	}
	
	
	
	public static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) return false;
		
		parents[rootA] = rootB;
		return true;
	}
	
	public static int find(int a) {
		if (parents[a] != a) {
			parents[a] = find(parents[a]);
		}
		
		return parents[a];
	}
}

