import java.util.*;

public class Main{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        
        int n = 1;

        while((1 + n*(n-1)/2) <= x) {
        	n++;
        }
        
        n--;  // 이건 while 문 조건 때문에 빼주는 거 
        // x가 수열값에 걸치든(Ex, x=2일 때 n=2) 그 이상이든 항상 n+1 값 갖고 탈출하게 while 문 설정해뒀음

        int s = x - (n*(n-1)/2);    // 구한 n 값에 맞춰서 순서 다시 정의 (Ex. x=2일 때, n=2이고, 이때 순서 s는 s=1나오도록)
        
        if (n%2==1) System.out.print((n-s+1) + "/" + s); // n 홀짝에 따라서 출력 형식 설정
        else System.out.print(s + "/" + (n-s+1));
	}
}
