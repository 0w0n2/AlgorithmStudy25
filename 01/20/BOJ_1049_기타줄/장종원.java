import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int minPackage = Integer.MAX_VALUE;
        int minPiece = Integer.MAX_VALUE;
        int[] listN = new int[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            minPackage = Math.min(minPackage, Integer.parseInt(st.nextToken()));   // 묶음 최소값
            minPiece = Math.min(minPiece, Integer.parseInt(st.nextToken()));       // 낱개 최소값
        }

        if (N < 6) {
            System.out.println(Math.min(minPackage, minPiece * N));     // 6개 이하일대 묶음과 해당 개수의 낱개 가격 비교
        } else {
            if (minPackage > minPiece * 6) {                           // 이상일때 6개 낱개가 묶음보다 쌀때 낱개로만
                System.out.println(minPiece * N);
            } else {
                if (minPackage >= minPiece * (N % 6)) {               // 묶음이 더 싸 묶음을 사고 남은 개수를 낱개로 살때가 더 쌀때
                    System.out.println(minPackage * (N / 6) + minPiece * (N % 6));
                } else {
                    System.out.println(minPackage * ((N / 6) + 1)); //남은 개수가 낱개로 사는것보다 묶음으로 살때가 더 쌀때
                }
            }
        }
    }
}
