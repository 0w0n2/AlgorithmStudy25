import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        bfs(n, k);
    }
    static class Node {
    	int x, time;
    	Node(int x, int time){
    		this.x = x;
    		this.time = time;
    	}
    }
    
    public static void bfs(int n, int k){
    	int maxLen = 100_000;
    	Deque<Node> q = new LinkedList<>();
        boolean[] isVisited = new boolean[maxLen+1];
        int[] dx = {-1, 1};
        
        q.addFirst(new Node(n, 0));
        isVisited[n] = true;
        
        while(!q.isEmpty()){
            Node current = q.poll();
            if (current.x==k){
                System.out.print(current.time);
                return;
            }
            int nextN2 = current.x*2;
            if (nextN2<=maxLen && !isVisited[nextN2]) {
            	q.addFirst(new Node(nextN2, current.time));
                isVisited[nextN2] = true;
            }
            for (int i=0;i<2;i++){
                int nextN = current.x + dx[i];
                if (nextN<0||nextN>maxLen||isVisited[nextN]) continue;
                q.addLast(new Node(nextN, current.time+1));
                isVisited[nextN] = true;
            }
        }
    }
}
