import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int node = Integer.parseInt(br.readLine());  //노드
        int line = Integer.parseInt(br.readLine());  //간선

        graph = new ArrayList<>();              // 그래프 초기화
        for(int i=0; i <= node; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[node + 1];

        for(int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());          // 그래프 값 입
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        dfs(1);
        
        System.out.println(count - 1);          // 지 제외
    }
    
    public static void dfs(int start) {            // dfs
        visited[start] = true;
        count++;                                     // 오염된 컴퓨터 수
        
        for(int neighbor : graph.get(start)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}
