import java.io.*;
import java.util.*;


public class Main {
    static int dx[]={0,1,0,-1};
    static int dy[]={1,0,-1,0};
    static int R,C;
    static char A [][];
    static boolean[] visit = new boolean[26];
    static int maxLength=0;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        R=Integer.parseInt(str[0]);
        C=Integer.parseInt(str[1]);

        A=new char[R][C];
        for(int i=0; i<R; i++){
            A[i]=br.readLine().toCharArray();
        }
        dfs(0,0,1);
        System.out.println(maxLength);
    }
    static void dfs(int x,int y, int length){
        maxLength = Math.max(maxLength,length);
        visit[A[x][y] - 'A'] = true; //현재 위치 방문처리

        for(int i=0; i<4; i++){
            int nx=x+dx[i];
            int ny = y+dy[i];
            //범위내에 있고,방문x알파벳이면
            if(nx>=0 && ny>=0 && nx<R && ny<C && !visit[A[nx][ny] - 'A']){
                dfs(nx,ny,length+1);//길이 1증가
            }
        }
        visit[A[x][y]-'A']=false; //탐색x하면 상태를 되돌려서 그 다음경로 확인
    }
}
