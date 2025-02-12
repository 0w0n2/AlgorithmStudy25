import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int N1 = str1.length();
        int N2 = str2.length();

        int[][] dp = new int[N1 + 1][N2 +1];

        for(int i = 1; i <= N1; i++) {
            for(int j=1; j <= N2; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[N1][N2]);
    }
}

