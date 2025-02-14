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
    public static void bfs(int n, int k){
    	int maxLen = 100_000;
        Queue<int[]> q = new LinkedList<>();
        boolean[] isVisited = new boolean[maxLen+1];
        int [] dx = {-1, 1};
        q.offer(new int[] {n, 0});
        while(!q.isEmpty()){
            int[] current = q.poll();
            if (current[0]==k){
                System.out.print(current[1]);
                return;
            }
            for (int i=0;i<2;i++){
                int nextN = current[0] + dx[i];
                if (nextN<0||nextN>maxLen||isVisited[nextN]) continue;
                q.offer(new int [] {nextN, current[1]+1});
                isVisited[nextN] = true;
            }
            int nextN2 = current[0]*2;
            if (nextN2<=maxLen && !isVisited[nextN2]) {
                q.offer(new int[] {nextN2, current[1]+1});
                isVisited[nextN2] = true;
            }
        }
    }
}

