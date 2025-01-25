import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        
        int i = 1; // 대각선 번호
        int sum = 0; // 이전 대각선까지의 숫자 합
        
        while (true) {
            sum += i;
            if (x <= sum) break;
            i++;
        }
        
        int offset = x - (sum - i); // 해당 대각선에서의 순서
        
        int a; // 분자
        int b; // 분모

        // 홀수 대각선
        if (i % 2 == 1) {
            a = i - (offset - 1);
            b = offset;
        }
        // 짝수 대각선
        else {
            a = offset;
            b = i - (offset - 1);
        }
        
        System.out.println(a + "/" + b);
    }
}
