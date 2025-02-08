import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int low = 1;
        int high = N;

        int[] start = new int[K];
        int[] end = new int[K];
        int[] term = new int[K];
        for(int i = 0; i < K ; i++) {
            st = new StringTokenizer(br.readLine());
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
            term[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        while(low <= high) {
            int mid = (low + high) / 2;
            long sum = 0;   // long안하고 다른 곳에서 틀린거 찾고 있었네 ;;
                           //  D는 모든 규칙으로 넣을 수 있는 도토리의 수보다 같거나 작다. -> sum은 20억 넘을 수 있다 -> long
            for(int i = 0 ; i < K ; i++) {
                if (start[i] <= mid) {
                    sum += (Math.min(end[i], mid) - start[i]) / term[i] + 1;
                }
            }

            if(sum >= D) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        System.out.println(result);
    }
}

