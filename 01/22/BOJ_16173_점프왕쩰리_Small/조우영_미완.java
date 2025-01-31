import java.util.Scanner;

public class Main{
    public static int[][] map;
    public static boolean[][] visited;
    public static int size;
    public static boolean result=false;

    private static void dfs(int i, int j) {
        if(i<0 || i>size || j<0 || j>size || !visited[i][j]){
            visited[i][j] = true;

            if(map[i][j] == -1){
                result = true;
                return;
            }

            // 우로 1칸
            if(j + map[i][j] < size){
                dfs(i, j+map[i][j]);
            }

            // 아래로 1칸
            if(i + map[i][j] < size){
                dfs(i+map[i][j], j);
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();

        // 크기설정
        map = new int[size][size];
        visited = new boolean[size][size];

        // 배열 입력
        for (int i=0;i<size;i++) {
            for (int j=0;j<size;j++) {
                map[i][j] = sc.nextInt();
            }
        }
        dfs(0,0);
        System.out.println(result ? "HaruHaru" : "Hing");
    }
}

