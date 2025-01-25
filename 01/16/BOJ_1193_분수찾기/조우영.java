import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int k = 1; // 대각선 번호 초기값
        while(k*(k+1)/2 <= T){ // T가 포함된 대각선 번호 찾기
            k++;
        }
        k--; // T가 포함된 대각선 번호 하나 벗어나게 했으므로

        if(k%2==1){
            System.out.println((T-(2*k-1)) + "/"+(T-k));
        }else{
            System.out.println((T-k) + "/" +(T-(2*k-1)));
        }
    }
}
