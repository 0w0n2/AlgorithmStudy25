import java.io.*;
import java.util.*;


public class Main {
    static int dx[]={0,1,0,-1};
    static int dy[]={1,0,-1,0};
    static int A[][];
    static int N,M;
    static List<int[]> emptySpace=new ArrayList<>();
    static int maxSafeArea=0;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        A=new int[N][M];

        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                A[i][j]=Integer.parseInt(st.nextToken());
                if(A[i][j] == 0){
                    emptySpace.add(new int[]{i,j});// 0:빈공간 넣어버림 바로
                }
            }
        }
        buildWall(0,0);
        System.out.println(maxSafeArea); //모든 벽 만들고 최대 구하기

    }
    static void buildWall(int count,int start){//일단 벽세움
        if(count ==3){
            VirusSpread(); //벽 3개 세우면 바이러스 확산 시킬거임
            return;
        }                 //이런식으로 모든 경우 생각해서 최대 넓이 구상
        for(int i = start; i<emptySpace.size();i++){
            int []position = emptySpace.get(i);
            A[position[0]][position[1]] = 1;
            buildWall(count +1,i+1);
            A[position[0]][position[1]]=0;
        }//모든 벽 탐색 이게 젤 골치아팠음
    }//재귀로 계속 불러서 3번째 벽까지 설치하고 바이러스 퍼트리고
    //벽 제거 후 모든 3번째벽 변수 돌리고 차후 2번째 1번째 벽돌림
    static void VirusSpread(){
        int[][] temp = new int[N][M];
        for(int i=0; i<N; i++){ //저기 벽3개 세운 상태를 복사해
            temp[i]=A[i].clone();//바이러스 퍼트릴거임
        }

        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(temp[i][j]==2){//바이러스들을 큐에 넣고
                    queue.add(new int[]{i,j});//큐 끝날때까지
                }//바이러스 확산시킬거임
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size;i++){
                int current [] = queue.poll();
                for(int j=0; j<4; j++){
                    int x = current[0] + dx[j];
                    int y = current[1] + dy[j];
                    if(x>=0 && y>=0 && x<N && y<M && temp[x][y]==0){
                        temp[x][y] =2;
                        queue.add(new int[]{x,y});
                    }
                }
            }
        }
        int safeArea = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(temp[i][j]==0){
                    safeArea++;
                }
            }
        }
        maxSafeArea=Math.max(maxSafeArea,safeArea);
    }


}

