import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger[] dp = new BigInteger[251];
        dp[0] = new BigInteger("1"); // 아무 타일을 쓰지 않는 방법도 1가지라네요;;;;;;;;
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("3");
        for (int i=3;i<=250;i++) dp[i] = dp[i-1].add(dp[i-2].multiply(new BigInteger("2"))); // add => O(n) mul => O(n^2)  n은 곱해지는 숫자의 자릿수 --> 어디서는 BigInteger multiply가 nlogn 이라던데 뭐가 맞는지 몰겠
        String ip = "";
        while((ip=br.readLine())!=null ){
            System.out.println(dp[Integer.parseInt(ip)]);
        }
        // 전체 시간 복잡도 : O(n^3) 또는 O(n^2log n)
    }
}

