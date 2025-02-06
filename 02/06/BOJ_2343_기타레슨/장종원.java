import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        long start = 0;
        long end = 0;
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start, arr[i]);
            end += arr[i];
        }
        
        long result = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
        	
            int count = 1;
            long sum = 0;
        	
            for (int i = 0; i < N; i++) {
                if (sum + arr[i] > mid) {
                    count++;
                    sum = arr[i];
                } else {
                    sum += arr[i];
                }
            }
        	
            if (count > M) {
                start = mid + 1;
            } else {
                result = mid;
                end = mid - 1;
            }
        }
        
        System.out.println(result);
    }
}

