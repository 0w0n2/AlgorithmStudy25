import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = 0;

        if (N == 1) {           // 이동 x
            result = 1;
        } else if (N == 2) {        // 두 번째, 세 번째 방법의 이동만 가능
            result = Math.min(4, (M + 1) / 2);
        } else {
            // N >= 3:
            if (M < 7) {            // 4가지 이동 규칙을 모두 사용 불가
                result = Math.min(4, M);
            } else {                // 모든 이동 규칙 사용 가능
                result = M - 2;
            }
        }

        System.out.println(result);
    }
}
