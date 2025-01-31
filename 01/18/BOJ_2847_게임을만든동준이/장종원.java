import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] listN = new int[n];
        for(int i=0; i < n ; i++) {
            listN[i] = Integer.parseInt(br.readLine());
        }
        int result = 0;
        for(int i=n-2 ; i >= 0 ; i--) {        레벨 높은 단계부터 차례로 이전 높은 단계보다 -1 점 부여
            if(listN[i] >= listN[i+1]) {
                result += listN[i] - listN[i+1] + 1;
                listN[i] = listN[i+1] -1;
            }
        }
        System.out.println(result);
    }
}
