import java.io.*;
import java.util.*;

//트리는 어떤 노드에서 시작하든 가장 깊은 먼 곳이 지름의 한 부분이 됨!
public class Main {
    static ArrayList<ArrayList<int[]>>graph;
    static boolean visit[];
    static int maxLen=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int length=Integer.parseInt(st.nextToken());
            graph.get(x).add(new int []{y,length});//각 노드에 연결된 노드와
            graph.get(y).add(new int []{x,length});//간선의 길이를 추가

        }
        visit = new boolean[N+1];
        DFS(1);
        System.out.println(maxLen);
    }

    static int DFS(int node){
        visit[node]=true;
        int maxDepthA=0;
        int maxDepthB=0;

        for(int[] near: graph.get(node)){//현재 노드에서 가장 먼 곳을 찾음
            int nearNode=near[0]; //가장 먼 노드에서 가장 먼 노드를 찾음
            int length = near[1];
            if(!visit[nearNode]){
                int depth = DFS(nearNode) + length;
                if(depth > maxDepthA){
                    maxDepthB=maxDepthA;
                    maxDepthA=depth;
                }
                else if(depth>maxDepthB){
                    maxDepthB=depth;
                }
            }
        }
        maxLen=Math.max(maxLen,maxDepthA+maxDepthB);
        return maxDepthA;

    }


    }

