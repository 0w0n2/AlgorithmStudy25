import java.io.*;
import java.util.*;

class Solution{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		
		// 테스트 케이스만큼 돌기
		for(int test_case=0;test_case<t;test_case++) {
			String[] input = br.readLine().split(" ");
			int j=Integer.parseInt(input[0]); // 캔디 개수
			int n=Integer.parseInt(input[1]); // 박스 개수

			//박스갯수만큼의 상자 생성
			Integer[] box = new Integer[n];
			for(int i=0;i<n;i++) {
				// 가로, 세로를 받아서 넓이를 구함
				String[] candy = br.readLine().split(" ");
				int width=Integer.parseInt(candy[0]);
				int length=Integer.parseInt(candy[1]);
				int size=width*length;
			
				box[i] = size; // 상자 크기배열에 넣음
			}
			
			// 내림차순으로 정렬
			Arrays.sort(box, Collections.reverseOrder());
			System.out.println(Arrays.toString(box));
			int count=0;
			for(int boxSize : box) {
				// 사탕개수가 음수이면 다음루프 돌기
				if(j<=0) continue;
				// 사탕개수에서 박스사이즈만큼 빼기
				j -= boxSize;
				// 담은 갯수 추가
				count++;
			}
			System.out.println(count);
		}		
	}
}
