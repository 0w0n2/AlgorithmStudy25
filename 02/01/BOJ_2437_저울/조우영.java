import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int sum=arr[0];
        // a[i]까지 누적 합 +1 이 다음 요소보다 크면 만들어진다네요?!!,
        // 예시 7까지 더하면 다음요소가 커져서 그 값에 1 더한 값(정답)을 못만든다 함
        for(int i=1;i<N;i++){
            if(sum+1 > arr[i]){
                sum += arr[i];
            }
        }
        System.out.println(sum+1);
    }
}

