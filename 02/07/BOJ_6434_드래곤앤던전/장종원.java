import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        long start = 1;
        long end = (long) 1e18;
        long result = 0;

        int[][] monsterArr = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            monsterArr[i][0] = Integer.parseInt(st.nextToken());
            monsterArr[i][1] = Integer.parseInt(st.nextToken());
            monsterArr[i][2] = Integer.parseInt(st.nextToken());
        }

        while (start <= end) {
            long mid = (start + end) / 2;
            long curHp = mid;
            long curH = H;
            boolean isAlive = true;

            for (int i = 0; i < N; i++) {
                if (monsterArr[i][0] == 1) {
                    long damage = (monsterArr[i][2] + curH - 1) / curH * monsterArr[i][1];
                    curHp -= damage - monsterArr[i][1];
                    if (curHp <= 0) {
                        isAlive = false;
                        break;
                    }
                } else {
                    curH += monsterArr[i][1];
                    curHp = Math.min(mid, curHp + monsterArr[i][2]);
                }
            }

            if (isAlive) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}

