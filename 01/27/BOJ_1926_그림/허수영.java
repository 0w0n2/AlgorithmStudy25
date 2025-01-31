import java.io.*;
import java.util.*;

//미로랑 똑같은식으로 운영
//상하좌우 탐색후 1이 있으면 그 위치를 큐에 넣어 버린후 개수셈
//area만들어서 그 넓이를 math함수 이용해서 최대 넓이 뽑아냄 
public class Main {
    static int dx[]={0,1,0,-1};
    static int dy[]={1,0,-1,0};
    static boolean visit[][];
    static int A[][];
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A= new int[N][M];
        visit = new boolean[N][M];

        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                A[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int max =0; //최대 넓이
        int count=0; // 연결된 1개수
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(A[i][j] == 1 && !visit[i][j]){
                    count++;
                    int area=BFS(i,j);
                    max=Math.max(max,area);
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }
    private static int BFS(int i, int j){
        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[] {i,j});
        visit[i][j] = true;
        int area=0;
        while(!queue.isEmpty()){

            int current[]= queue.poll();
            area++;
            for(int k =0; k<4; k++){
                int x = current[0] +dx[k];
                int y = current[1] + dy[k];
                if(x>=0 && y>=0 && x<N && y<M){
                    if(A[x][y]!=0 && !visit[x][y]){
                        visit[x][y]=true;
                        queue.add(new int[]{x,y});
                    }
                }
            }
        }
        return area;
    }
    }

