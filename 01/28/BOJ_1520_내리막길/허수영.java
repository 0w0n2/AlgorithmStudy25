import java.util.*;
import java.io.*;

public class Main {
    static int dx[]={0,1,0,-1};
    static int dy[]={1,0,-1,0};
    static int N,M;
    static int [][] cnt;
    static int [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        cnt=new int [N][M];

        for (int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                cnt[i][j]= -1;
            }
        }
        System.out.println(count(0,0));

    }
    public static int count(int x ,int y){
        if(x==N-1 && y==M-1){
            return 1;
        }
        if(cnt[x][y] != -1){
            return cnt[x][y];
        }
        int total=0;

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && ny>=0 && nx<N && ny<M && map[nx][ny]<map[x][y]){
                total+=count(nx,ny);
            }
        }
        cnt[x][y]=total;
        return total;
    }
}



