import java.util.*;
import java.io.*;

public class Main {
	static int[] par;
	
	static class Node{
		int v, u, weight;
		Node(int v, int u, int weight){
			this.v = v;
			this.u = u;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); // 정점의 개수(노드)
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		par = new int[V+1];
		Arrays.fill(par, -1);
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.weight-o2.weight;
			}
		});
		
		for (int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.offer(new Node(a, b, c));
		}
		
		long totalWeight = 0;
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			if(find(current.v, current.u)) totalWeight+=current.weight;
		}
		System.out.print(totalWeight);
	}
	
	public static int find(int x) { // find 함수
		if(par[x]==-1) return x;
		return par[x] = find(par[x]);
	}

	
	public static boolean find(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) return false;
		
		par[a] = b;
		return true;
	}
}
