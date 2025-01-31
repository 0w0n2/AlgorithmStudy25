import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int[] count = new int[26];                      // 아스키코드를 이용한 빈도배열 생성
        for (char c : word.toCharArray()) {
            count[c - 'A']++;     // "A"는 왜 안되지
        }

        int oddcount = 0;
        int oddindex = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {                 // 홀수는 최대 한개일때만 동작가능 해당 홀수 저장
                oddcount++;
                oddindex = i;
            }
        }

        if (oddcount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder frontlist = new StringBuilder();

        for (int i = 0; i < 26; i++) {                       //반으로 나눠서 앞과 뒤를 놔눠서 저장
            int freq = count[i] / 2;
            char c = (char) (i + 'A');
            for (int j = 0; j < freq; j++) {
                frontlist.append(c);
            }
        }

        StringBuilder backlist = new StringBuilder(frontlist).reverse();   // backlist를 호출하고 append로 (frontlist).reverse()를 사용하면 frontlist가 변형된다.
                                                                           // 그래서 호출할때 StringBuilder(frontlist).reverse()사용하여 frontlist 변형을 막음.

        if (oddcount == 1) {
            frontlist.append((char) (oddindex + 'A'));
        }

        System.out.println(frontlist.toString() + backlist.toString());
    }
}

