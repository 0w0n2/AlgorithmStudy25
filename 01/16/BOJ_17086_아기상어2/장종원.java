import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int max_distance = Integer.MIN_VALUE;
        
        ArrayList<Integer>[] danger_location = new ArrayList[2];   // 아기상어 위치 저장소 갯수 미정이기때문에 2차원 어레이 리스트       
        danger_location[0] = new ArrayList<>();
        danger_location[1] = new ArrayList<>();

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {                                 // 아기상어 위치 저장
                    danger_location[0].add(i);
                    danger_location[1].add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {                                 //완전 탐색
            for (int j = 0; j < m; j++) {
                int min_distance = Integer.MAX_VALUE;
                for (int k = 0; k < danger_location[0].size(); k++) {   
                	int dx = Math.abs(i - danger_location[0].get(k));
                	int dy = Math.abs(j - danger_location[1].get(k));
                    int distance = Math.max(dx, dy);                       // 대각선 이동 계산
                    min_distance = Math.min(min_distance, distance);
                }
                max_distance = Math.max(max_distance, min_distance);
            }
        }

        System.out.println(max_distance);
    }
}
