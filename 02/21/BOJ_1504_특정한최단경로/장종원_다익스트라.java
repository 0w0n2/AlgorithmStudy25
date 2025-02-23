package pratice221;

import java.io.*;
import java.util.*;

public class Solution_1753_최단경로2 {
	
	static int N, E;
	static List<List<Node>> graph;
	static PriorityQueue<Node> pq = new PriorityQueue<>((e1, e2)-> e1.weight - e2.weight);
	static int[] distance1;
	static int[] distance2;
	static int[] distance3;
	static boolean[] visited;
	
	static class Node {
		int node, weight;
		
		Node(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [node=" + node + ", weight=" + weight + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        
        distance1 = new int[N + 1];
        distance2 = new int[N + 1];
        distance3 = new int[N + 1];
        Arrays.fill(distance1, Integer.MAX_VALUE);
        Arrays.fill(distance2, Integer.MAX_VALUE);
        Arrays.fill(distance3, Integer.MAX_VALUE);
        visited = new boolean[N + 1];
        
        for(int i = 0; i < E ; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	
        	graph.get(a).add(new Node(b, w));
        	graph.get(b).add(new Node(a, w));
        }

        
        st = new StringTokenizer(br.readLine());
        int end1 = Integer.parseInt(st.nextToken());
        int end2 = Integer.parseInt(st.nextToken());
        
        
        // 1번 출발 최단거리
        dijstra(1, distance1);
        
        // 정점1 출발 최단거리
        visited = new boolean[N + 1];
        dijstra(end1, distance2);
        
        // 정점2 출발 최단거리
        visited = new boolean[N + 1];
        dijstra(end2, distance3);
        
        // 두가지의 도착 방법중 최단거리 선택
        int result = Math.min(distance1[end1] + distance3[N], distance1[end2] + distance2[N]) + distance2[end2];
        boolean ischeck = false;
        
        
        // 도착 방법이 없는 경우 if
        if((distance1[end1] == Integer.MAX_VALUE || distance3[N] == Integer.MAX_VALUE) &&
        		(distance1[end2] == Integer.MAX_VALUE || distance2[N] == Integer.MAX_VALUE))
        	ischeck = true;
        if(distance2[end2] == Integer.MAX_VALUE) ischeck = true;
        
        if(ischeck) System.out.println(-1);
        else System.out.println(result);
        
    }
	public static void dijstra(int start, int[] distance) {
		
		pq.offer(new Node(start, 0));
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.node]) continue;
			visited[cur.node] = true;
			
			
			for(Node next : graph.get(cur.node)) {
				if(visited[next.node]) continue;
				if(distance[next.node] <= distance[cur.node] + next.weight) continue;
				
				distance[next.node] = distance[cur.node] + next.weight;
				pq.offer(new Node(next.node, distance[next.node]));
			}
		}
	}
}

