import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean[] visited;
    static Queue<int[]> queue;
    static List<List<int[]>> graph; // 가중치도 있어 3차원으로 만들어야함
    static int maxDistance = 0;
    static int endNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= n ; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[] {b, l});
            graph.get(b).add(new int[] {a, l});
        }

        // 트리 구조상 어느 곳에서 시작하든 거기서 가장 먼 지점은 지름의 한지점이 된다.
        visited = new boolean[n + 1]; 
        dfs(1, 0);
        
        // 지름의 한지점을 찾고 그지점에서 가장 먼 노드를 찾아 거리를 계산하면 지름이 됨.
        visited = new boolean[n + 1];
        maxDistance = 0;
        dfs(endNode, 0);

        System.out.println(maxDistance);
    }


    // 한 노드 시작점에서 가장 먼 노드와 거리르 계산하는 dfs
    public static void dfs(int node, int distance) {
        visited[node] = true;

        if (distance > maxDistance) {
            maxDistance = distance;
            endNode = node;
        }

        for (int[] next : graph.get(node)) {
            int nextNode = next[0];
            int nextLength = next[1];
            if (!visited[nextNode]) {
                dfs(nextNode, distance + nextLength);
            }
        }
    }
}
