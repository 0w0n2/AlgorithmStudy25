import java.io.*;
import java.util.*;

//미로랑 똑같은식으로 운영
//
public class Main {
    static int dx[]={0,1,0,-1};
    static int dy[]={1,0,-1,0};
    //static boolean visit[][];
    static int A[][];
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A= new int[N][M];
      //  visit = new boolean[N][M];
        Queue<int[]>queue=new LinkedList<>();

        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                A[i][j]=Integer.parseInt(st.nextToken());
                if(A[i][j] ==1){
                    queue.add(new int[]{i,j}); //토마토가 익었나 안익었나 확인
                }
            }
        }
        int count=0; // 걸린 일수
        while(!queue.isEmpty()){ //아까 익은놈들을 큐에 넣음
            int size = queue.size(); //그거를 탐색후 익힘
            for(int i =0; i<size; i++){
                int current [] = queue.poll();
                for(int j=0; j<4;j++){
                    int x = current[0]+dx[j];
                    int y = current[1]+dy[j];
                    if(x>=0 && y>=0 && x<N && y<M && A[x][y] == 0){
                        A[x][y] = 1;
                        queue.add(new int[]{x,y});
                    }
                }
            }
            count++; //bfs끝날때마다 up

        }
        for(int i =0;i<N;i++){
            for(int j=0;j<M;j++){
                if(A[i][j]==0){
                    System.out.println(-1);//모두 안익었다면?
                    return;
                }
            }
        }

        System.out.println(count >0 ? count -1 : 0); //모든 토마토가 익어있었다면?
    }
    }

