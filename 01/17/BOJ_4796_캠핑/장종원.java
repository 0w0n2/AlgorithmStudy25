import java.io.*;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test_count = 1;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if(L == 0 ) break;

            int result = L * (V / P) + Math.min(L, V - P * (V / P));         
            System.out.printf("Case %d: %d\n", test_count,result);
            test_count++;

        }

    }
}
