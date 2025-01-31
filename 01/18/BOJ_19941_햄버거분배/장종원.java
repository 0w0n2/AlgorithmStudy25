import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String word = br.readLine();
        char[] listN = word.toCharArray();
        int result = 0;

        for (int i = 0; i < N; i++) {
            if (listN[i] == 'P') {
                for (int gap = -K; gap <= K; gap++) { // K 범위 안에서 확인 왼쪽 큰수부터 차례로
                    int target = i + gap;
                    if (target >= 0 && target < N && listN[target] == 'H') { // 유효한 범위인지 확인
                        listN[target] = 'X'; // 사용된 'H'를 표시
                        result++;
                        break;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
