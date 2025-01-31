import java.util.*;

public class Main{
	public static void main (String[] args)  {
		// 입력 단계
		Scanner sc = new Scanner (System.in);
		String inputWord = sc.nextLine();
		String [] Word = new String [inputWord.length()];
		for (int i=0;i<inputWord.length();i++) Word[i] = String.valueOf(inputWord.charAt(i)); // 문자를 하나하나씩 쪼개줌
		
		// 입력 받은 문자를 오름차순 정렬
		Arrays.sort(Word); 
		
		String [] palindrome = new String[inputWord.length()]; // 결과 문자열 저장용
		boolean [] used = new boolean[inputWord.length()];  // 결과를 만드는데 이미 사용한 문자인지 확인하는
		
		int j = 0;
		for (int i=0;i<inputWord.length()-1;i++) {
			if (Word[i].equals(Word[i+1])) { // 만약 똑같은 문자가 2개 있다면
				palindrome[j] = Word[i];
				palindrome[inputWord.length()-1-j] = Word[i]; // 결과 문자열(팰린드롬)의 앞 뒤에 저장해준다(j를 사용함으로써 점점 바깥쪽에서 안쪽으로 들어감)
				used[i] = true; 
				used[i+1] = true; // 해당 두 문자는 사용됐음
				j++;
				i++; // 결과적으로 i+=2 (for 조건) - 안 쓴 문자로 바로 넘어감
			} 
		}
		
		int remnant = 0; // 안 쓰고 남은 문자는 1개여야함(동일한 문자가 홀수개로 들어왔을 때, 팰린드롬의 중간에 위치시킴)
		for (int i=0; i<inputWord.length();i++) {
			if (!used[i]) {
				remnant++;
				if (remnant>1) { // 안 쓰고 남은 문자가 2개 이상이다 -> 여러 문자가 홀수개로 들어왔음... 이건 어떻게 배치해도 팰린드롬이 될 수 없음
					System.out.println("I'm Sorry Hansoo");
					return;
				}
				palindrome[inputWord.length()/2] = Word[i]; // 구해진 나머지를 팰린드롬의 중간에 배치해준다
			}
		}
		
		for (int i=0;i<inputWord.length();i++) System.out.print(palindrome[i]);
	}	
}
