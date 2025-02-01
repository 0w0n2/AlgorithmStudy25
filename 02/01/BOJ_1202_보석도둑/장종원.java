import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arrGem = new int[N][2];
        int[] arrBag = new int[K];
        long result = 0; // N이 30만개, 가방무게가 1억이 될 수 있어 int 범위를 넘길 가능성이 큼
        int idx = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arrGem[i][0] = Integer.parseInt(st.nextToken());
            arrGem[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < K; i++) {
            arrBag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arrGem, (a, b) -> (a[0] == b[0]) ? b[1] - a[1] : a[0] - b[0]);
        Arrays.sort(arrBag);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int bag : arrBag) {         //우선순위 큐
            while (idx < N && arrGem[idx][0] <= bag) {     // 작은가방부터 들어갈수 있는 보석 다 넣음
                pq.offer(arrGem[idx][1]);
                idx++;
            }

            if (!pq.isEmpty()) {         // 그중 가장 비싼 빼
                result += pq.poll();
            }
        }

        System.out.println(result);
    }
}
