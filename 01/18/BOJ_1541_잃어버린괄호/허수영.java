import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int total = 0;
        boolean firstnum = true; //첫번째는 무조건 더함

        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            StringTokenizer plustoken = new StringTokenizer(str, "+");
            int sum = 0;

            while (plustoken.hasMoreTokens()) {
                sum += Integer.parseInt(plustoken.nextToken()); //그후 +토큰 나눔
            }

            if (firstnum) {
                total += sum;
                firstnum = false;
            } else {
                total -= sum; //첫번쨰 제외 다 뺌
            }
        }

        System.out.println(total);
    }
}
