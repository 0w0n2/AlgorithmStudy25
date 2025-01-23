import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 1; i <= n; i++) {
            String word = br.readLine();
            char[] list_word = new char[word.length()];
            boolean istrue = false;

            for (int j = 0; j < word.length(); j++) { // 받은 문자열 배열로 변환
                list_word[j] = word.charAt(j);
            }

            List<String> array_list_word = new ArrayList<>();
            for (char c : list_word) {
                array_list_word.add(String.valueOf(c)); // 배열 -> arraylist로 변환
            }

            for (int j = 1; j < word.length(); j++) {       // 문자가 달라지는 시점에서 해당 문자가 나머지 문자열에 존재하는지 확인
                if (list_word[j - 1] != list_word[j]) {
                    if (array_list_word.subList(j, array_list_word.size()).contains(String.valueOf(list_word[j - 1]))) {
                        istrue = true;
                        break;
                    }   
                }
            }

            if (istrue == false) {   // 모두 돌렸을때 해당 문제가 없다면 +1
                result += 1;
            }
        }

        System.out.println(result);
    }
}
