import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Node>> map = new ArrayList<>();
    static int deep;
    static int radius;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i=0;i<=n;i++) map.add(new ArrayList<>());

        for (int i=0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken()); // 가중치 (길이)
            map.get(v).add(new Node(u, w));
            map.get(u).add(new Node(v, w));
        }

        boolean[] isVisited = new boolean[n + 1];
        radius = 0;
        dfs(n, isVisited, 0); 
        // n번 노드부터 최대한 깊게 검색하면서 가장 긴 지름을 만들 수 있는 시작 노드를 찾기
        // n번으로 설정한 이유는 일반적으로 n이면 1번 노드에서 거리가 가장 머니까 확률적으로 빨리 dfs 끝날 거 같아서

        isVisited = new boolean[n+1];
        radius = 0;
        dfs(deep, isVisited, 0); // 찾은 시작 노드부터 가능한 가장 긴 지름을 만들기
        System.out.println(radius);
    }
    public static void dfs(int v, boolean[] isVisited, int w){
		    // v : 현재 노드, w : 현재까지 계산된 길이
        isVisited[v] = true;

        if (w>radius){ // 가장 긴 지름을 만들 수 있는 시작 노드를 찾기
            radius = w;
            deep = v;
        }

        for (Node next : map.get(v)){
            if(!isVisited[next.nv]) dfs(next.nv, isVisited, w+next.weight);
        }
    }

    static class Node{ // new int[] {nv, weight} 꼴... 한 간선에 가중치까지 같이 저장하려고 이렇게 함
        int nv;
        int weight;
        public Node(int nv, int weight){
            this.nv = nv;
            this.weight = weight;
        }
    }
}

