import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        boolean checkZreo = false;
        boolean check1 = false;

        List<Integer> negative = new ArrayList<>(); 
        List<Integer> postive = new ArrayList<>();

        for(int i = 0 ; i < N ; i++) {
            int number = Integer.parseInt(br.readLine()); // 음수, 양수 리스트 나눠서 담고 0, 1 따로 체크만 함
            if(number < 0) negative.add(number);
            else if(number > 1) postive.add(number);
            else if (number == 0)checkZreo = true;
            else result += 1;     // 1이 있다면 바로 result에 더함
        }

        Collections.sort(negative);
        Collections.sort(postive, Collections.reverseOrder());

        for(int i = 0; i < postive.size() ; i += 2) {    //양수
            if(i + 1 < postive.size()) {
                result += (postive.get(i) * postive.get(i+1));
            } else result += postive.get(i);
        }

        for(int i = 0; i < negative.size() ; i += 2) {       //음수
            if(i + 1 < negative.size()) {
                result += (negative.get(i) * negative.get(i+1));
            } else {
                if (checkZreo) continue;      //음수 개수가 홀수 일때 
                else result += negative.get(i); //0이 있다면 음수의 가장 큰값과 곱해서 없앤다.
            }
        }
        System.out.println(result);
    }
}
