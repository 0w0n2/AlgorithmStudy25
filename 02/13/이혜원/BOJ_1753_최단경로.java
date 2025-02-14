import java.util.*;
import java.io.*;

public class Main {
	static class Node{
		int v, w;
		Node(int v, int w){
			this.v = v;
			this.w = w;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numV = Integer.parseInt(st.nextToken());
		int numE = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Node>> map = new ArrayList<>();
		for (int i=0;i<=numV;i++) map.add(new ArrayList<Node>());
		for (int i=0;i<numE;i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			map.get(v).add(new Node(u, w));
		}
		int [] dist = new int[numV+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[target] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.w - o2.w;
			}
		});
		pq.offer(new Node(target, 0));
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			int v = current.v;
			int w = current.w;
			if(dist[v]!=w) continue;
			
			for (Node nextInfo : map.get(v)) {
				int nv = nextInfo.v;
				int nw = nextInfo.w + w;
				if (dist[nv]>nw) {
					dist[nv] = nw;
					pq.offer(new Node(nv, nw));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=numV; i++) {
			if (dist[i]==Integer.MAX_VALUE) sb.append("INF").append("\n");
			else sb.append(dist[i]).append("\n");
		}
		System.out.print(sb);
	}
	
}
