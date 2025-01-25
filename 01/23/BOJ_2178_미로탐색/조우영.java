import java.io.*;
import java.util.*;

//방문 배열 체크 리스트 배열을 만들고,인접리스트를 생성해야함
public class Main {
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0}; //->밑 오 위 왼
    static boolean visit [][]; //방문 체크~
    static int A [][] ; // 입력 받은거
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        A=new int[N][M]; //미로만듬
        visit = new boolean[N][M];//방문체크~

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0; j<M;j++){
                A[i][j] = Integer.parseInt(line.substring(j,j+1)); //100101110같은거 넣음

            }
        }
        BFS(0,0);
        System.out.println(A[N-1][M-1]); //인덱스 0부터시작해서 하나씩 뻄
    }
    private static void BFS(int i,int j){
        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[] {i,j});
        visit[i][j] = true;
        while(!queue.isEmpty()){ //큐 다뺴낼때까지 돌려버림(bfs선택 안될떄까지)
            int current[] = queue.poll(); //현재 장소
            for(int k=0; k<4; k++){
                int x = current[0] + dx[k]; //위에 선언한넘으로
                int y = current[1] + dy[k]; //상하좌우 무빙할거
                if(x>=0 && y>=0 && x<N && y<M){ //미로 나가버리면 안됨
                    if(A[x][y]!=0 && !visit[x][y]){ //벽이나 방문안한곳
                        visit[x][y] = true; //방문해버림
                        A[x][y]=A[current[0]][current[1]] +1; //그리고 현재 위체에서 1올려버림 그래서 상하자우 탐색한곳을
                        queue.add(new int[]{x,y});            // 2,3,4,depth마냥 올려버려서 최종 depth
                                                                // 구해버림
                    }
                }
            }
        }
    }
}
