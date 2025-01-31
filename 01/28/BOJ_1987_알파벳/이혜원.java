import java.util.*;
import java.io.*;

public class Main {
    static int r, c;
    static char[][] map;
    static boolean [] alpha = new boolean[26];
    static int max = 0;
    static int [] dx = {1, -1, 0, 0};
    static int [] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for(int i=0;i<r;i++){
            String input = br.readLine();
            for (int j=0;j<input.length();j++) map[i][j] = input.charAt(j);
        }
        alpha[map[0][0]-'A'] = true;
        dfs(0, 0, 1);
        System.out.println(max);
    }
    public static void dfs(int x, int y, int count){
        max = Math.max(count, max);

        for (int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx<0||nx>=r||ny<0||ny>=c) continue;
            if (!alpha[map[nx][ny]-'A']){
                alpha[map[nx][ny]-'A'] = true;
                dfs(nx, ny, count+1);
                alpha[map[nx][ny]-'A'] = false;
            }
        }
    }
}
