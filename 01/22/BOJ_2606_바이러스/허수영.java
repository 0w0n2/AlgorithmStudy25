import java.io.*;
import java.util.*;

//방문 배열 체크 리스트 배열을 만들고,인접리스트를 생성해야함
public class Main {

    static ArrayList<ArrayList<Integer>> graph;// 인접리스트를 생성 위해선 이중 리스트를 만들어야함(노드 간선으로 구성 되는데 각 노드마다 간선수가 다를 수 있으므로)
    static boolean[] visit;
    static int count=0;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //컴퓨터수
        int M = Integer.parseInt(br.readLine());//컴퓨터 쌍의 수

        visit= new boolean[N+1];
        graph= new ArrayList<>();

        for(int i =0; i<=N; i++){
            graph.add(new ArrayList<>());//각 노드에 대해 빈 배열 추가해서 각 노드에 대한 연결된 노드들을 저장함
        }

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y); //양방향이라 둘다 추가해줘야함
            graph.get(y).add(x);
        }
        DFS(1);

        System.out.println(count);

      }
      static void DFS(int node){
        visit[node] = true; //현재 온 곳 방문 체크

        for(int neighbor : graph.get(node)){//현재 노드와 연결된 노드에 대해 방문
            if(!visit[neighbor]){
                count++;
                DFS(neighbor);
            }
        }
      }
}
