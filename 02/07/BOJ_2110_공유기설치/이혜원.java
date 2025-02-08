import java.util.*;
import java.io.*;

class Main
{	
	static int n, c; // 집 개수, 공유기 개수
	static int [] home;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 집 개수
		c = Integer.parseInt(st.nextToken()); // 공유기 개수
		home = new int[n];
		int maxHome = 0;
		for (int i=0; i<n; i++) {
			home[i]=Integer.parseInt(br.readLine());
			maxHome = Math.max(maxHome, home[i]);
		}
		Arrays.sort(home); // 집의 좌표를 오름차순 정렬
		
		// d = 인접한 최대 거리
		// Binary Search
		// Ex1, 예제 입력1) D=4 -> 1->5 : 다음 공유기 8,9  중 선택 가능
		// 						 8 선택 -> 8+4 = 12 -> 12 이상 좌표의 집 없음 -> 가능한 인접거리가 아님
		//						-> d 탐색 범위를 감소시켜야 함
		// Ex2, 예제 입력2) D=3 -> 1->4 : 다음 공유기 4, 8, 9, 중 선택 가능
		//						4 선택 -> 4+3 = 7 -> 다음 공유기 8, 9 중 선택 가능 -> 가능한 인접거리 !
		//						-> d 탐색 범위를 키워서 더 큰 가능한 최대 d가 없는지 확인해보자
		int start = 1;
		int end = maxHome;
		int result = 0;
		
		while(start<=end) {
			int d = (start+end)/2; // 중간점 => 검증할 인접거리(d)
			 
			boolean isAvailable = counting(d); // 검증
			
			if (isAvailable) {
				start = d+1;
				result = d;
			}
			else {
				end = d-1;
			}
		}
		System.out.println(result);
	}
	
	public static boolean counting(int d) {
		int count = 1;
		int lastHome = home[0];
		
		for (int i=1;i<n;i++) {
			if (home[i]-lastHome>=d) {
				count++;
				lastHome = home[i];
			}
		}
		return count>=c;
	}
}
