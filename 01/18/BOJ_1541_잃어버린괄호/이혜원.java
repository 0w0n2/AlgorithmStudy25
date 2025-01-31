import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String equation = br.readLine();

        int [] smallSum = new int[50]; // 부분합을 저장하는 변수
        int s = 0; // smallSum 배열의 인덱스
        String stack = ""; // 숫자 하나를 저장하는 변수
        
        for (int i=0;i<equation.length();i++){
            if (equation.charAt(i)=='+'||equation.charAt(i)=='-'){ // 기호를 발견했다 -> (2) 부분합으로 저장 
                smallSum[s] += Integer.parseInt(stack);
                stack = ""; // 숫자 저장 변수 초기화
                if (equation.charAt(i)=='-') s++; // 만약 기호가 "-"이다 -> (3) 다음 번째 부분합으로 이동
            } else {  // (1) 숫자 하나를 저장함(stack)
                stack += equation.charAt(i);
                if (i==(equation.length()-1)) smallSum[s] += Integer.parseInt(stack); // 입력의 마지막 숫자를 부분합에 저장하기 위한 줄(구분해줄 기호가 없으니까 이 줄 없으면 마지막 숫자 무시됨)
            }
        }
        int sum = smallSum[0];   // 출력 : smallSum[0] - (smallSum[1] + smallSum[2] + … + smallSum[end])
        for (int i=1; i<=s; i++) sum-=smallSum[i];
        System.out.println(sum);
    }
}
