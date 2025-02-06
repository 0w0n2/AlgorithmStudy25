import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int low = 0;     // 상한선이 매우 낮을 수 있어 배열중 가장 작은 값으로 설정 x
        int high = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, arr[i]);
        }

        int totalMoney = Integer.parseInt(br.readLine());


        int result = 0;
        while(low <= high) {
            int mid = (low + high) / 2;

            long sum = 0;

            for(int money : arr) {
                sum += Math.min(money, mid);
            }

            if (sum <= totalMoney) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}
