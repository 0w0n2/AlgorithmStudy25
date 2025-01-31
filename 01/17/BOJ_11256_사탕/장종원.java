import java.io.*;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for(int k = 0; k < n; k++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                arr[k] = r * c;
            }
            Arrays.sort(arr);                       //상자크기 정렬해서 큰 상자순으로 차례로 담아 계산

            int result = 0;
            int index = arr.length-1;
            while(true) {
                if(j <= 0) break;
                j -= arr[index];
                index--;
                result++;
            }
            System.out.println(result);
        }
    }
}
