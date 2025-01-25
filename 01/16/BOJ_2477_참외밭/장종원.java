import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[][] edges = new int[6][2]; // 방향과 길이를 저장하는 배열
        int big_area = 0;
        int small_area = 0;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken()); // 방향
            edges[i][1] = Integer.parseInt(st.nextToken()); // 길이
        }

        // 큰 사각형과 작은 사각형의 면적 계산
        for (int i = 0; i < 6; i++) {
            int cur = edges[i][1];
            int next = edges[(i + 1) % 6][1]; // 다음 변의 길이
            if (big_area < cur * next) {
                big_area = cur * next; // 큰 사각형 면적
                small_area = edges[(i + 3) % 6][1] * edges[(i + 4) % 6][1]; // 작은 사각형 면적
            }
        }

        // 결과 계산 및 출력
        int result = k * (big_area - small_area);
        System.out.println(result);
    }
}
