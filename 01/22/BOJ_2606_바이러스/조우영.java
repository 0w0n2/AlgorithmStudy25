import java.util.*;

public class Main{
    public static int node;
    public static int line;
    public static boolean[] visited;
    public static int[][] map;
    public static int result=0;
		
		// dfs메서드
    private static void dfs(int i) {
        visited[i] = true;
        result++;
				
        for (int j=1; j<=node; j++) {
            if(map[i][j]==1 && !visited[j]) dfs(j);
        }
    }
		
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        node = sc.nextInt();
        line = sc.nextInt();

        // 크기 지정
        map = new int[node+1][node+1]; // 1,1부터 시작할것이기 때문
        visited = new boolean[node+1]; // 1부터 시작

        for (int i = 0; i < line; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            map[x][y] = map[y][x] = 1; // 2,5와 5,2같으니깐
        }
        dfs(1);
        System.out.println(result-1); // 1제외 값 출력
    }
}

