import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		
		boolean[] isPrime = new boolean[n + 1];  // 불리언 배열을 통해 완전탐색형식
		Arrays.fill(isPrime, true);
		
		isPrime[0] = false;
		isPrime[1] = false;
		
		int count = 0;
		for (int i = 2; i <= n ; i++) {      
			if (isPrime[i]) {                        // 소수가 나타났으면
				for (int j = i; j <= n ; j += i) {     // 해당 소수의 배수는 모두 소수가 아니기때문에 제거
					if (isPrime[j]) {
						isPrime[j] = false;
						count++;
						if (count == k) {
							System.out.println(j);
							return;
						
					}
				}
			}
		}
		
	}
}
}
