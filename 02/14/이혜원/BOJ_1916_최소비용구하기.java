import java.util.*;
import java.io.*;
public class Main {
	static class Node{
		int v, money;
		Node(int v, int money){
			this.v = v;
			this.money = money;
		}
	}
	
	static ArrayList<ArrayList<Node>> map = new ArrayList<>();
	static int [] dist;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 도시의 개수(node)
		int M = Integer.parseInt(br.readLine()); // 버스의 개수(line)
		for (int i=0;i<=N;i++) map.add(new ArrayList<Node>());
		
		
		StringTokenizer st; 
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int money = Integer.parseInt(st.nextToken());
			map.get(v).add(new Node(u, money)); // 방향 그래프
		} // 입력 완
		
		st = new StringTokenizer(br.readLine());
		int startPoint = Integer.parseInt(st.nextToken());
		int endPoint = Integer.parseInt(st.nextToken());
		dist = new int[N+1]; 
		Arrays.fill(dist, Integer.MAX_VALUE);
		bfs(startPoint);
		System.out.print(dist[endPoint]);
	}
	
	public static void bfs(int startPoint) {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.money - o2.money; // 우선순위 큐, 금액이 제일 낮은 순으로 빼자(오름차순)
			}
		}); 
		// startPoint 부터 다른 지점까지 가는 모든 최소 비용을 검사할 거임 뭐지 도착지점이 정해져있네
		dist[startPoint] = 0;
		pq.offer(new Node(startPoint, 0));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			int cv = current.v;
			int cm = current.money;
			if (dist[cv]!=cm) continue; // 삭제된 값이라 무시 (최솟값 아님)
			
			for (Node nextPoint:map.get(cv)) {
				int nv = nextPoint.v;
				int nm = nextPoint.money + cm;
				if (dist[nv]>nm) {
					dist[nv] = nm; // 최소 경로로 교체
					pq.offer(new Node(nv, nm));
				}
			}
		}	
	}
}

