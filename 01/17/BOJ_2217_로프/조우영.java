import java.io.*;
import java.util.*;

class Main{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		
		// 배열에 로프 중량 저장
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0;i<t;i++) {
			arr.add(sc.nextInt());
		}
		Collections.sort(arr);
		
		// 마지막인수(최대값)을 리스트에 넣으면서 값 비교
		int resultNum =0; // 마지막 결과값 저장
		int newResultNum =0;
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=arr.size()-1;i>=0;i--) {
			int lastNum = arr.get(arr.size()-1);
	    arr.remove(arr.size() - 1); // 원래 배열에서 제거
			result.add(lastNum); // 결과 배열에 저장

			// 결과배열에서 최소값구하기
			int min =result.get(result.size()-1);
			
			// 최소*갯수 결과값 저장, 이전 결과값과 비교 후 작으면 
			resultNum = min*result.size();
			if(resultNum < newResultNum) {
				continue;
			}
			newResultNum=resultNum;
		}
		
		System.out.println(newResultNum);
	}
}
