import java.io.*;
import java.util.*;

public class Main {
    static int [][] dp = new int[1001][3];
    static int [][] costs;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 집 개수
        costs = new int[n+1][3]; // 집 칠하는 비용

        for (int i=0; i<n; i++){ // 탑다운 O(n)
            StringTokenizer st = new StringTokenizer(br.readLine());
            costs[i][0] = Integer.parseInt(st.nextToken());
            costs[i][1] = Integer.parseInt(st.nextToken());
            costs[i][2] = Integer.parseInt(st.nextToken());
        }
        System.out.print(Math.min(Math.min(f(n-1, 0), f(n-1, 1)), f(n-1, 2)));
    }
    
    public static int f(int i, int lastNum){ // O(n)
        if(i==0) return costs[i][lastNum];
        else if(dp[i][lastNum]==0){ // 미방문
            if(lastNum==0) dp[i][lastNum] = Math.min(f(i-1, 1), f(i-1, 2))+ costs[i][0];
            if(lastNum==1) dp[i][lastNum] = Math.min(f(i-1, 0), f(i-1, 2))+ costs[i][1];
            if(lastNum==2) dp[i][lastNum] = Math.min(f(i-1, 0), f(i-1, 1))+ costs[i][2];
        }
        return dp[i][lastNum];
    }
}
