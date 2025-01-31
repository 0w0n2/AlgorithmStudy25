import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for(int i= 0; i < N ; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, Comparator.comparingInt(String::length).reversed());

        Set<String> frontwords = new HashSet<>(); // set 중복제거
        int result = 0;

        for(String word : words) {
            boolean isFront = false;
            for(String front : frontwords) {       //접두사 체크
                if(front.startsWith(word)) {
                    isFront = true;
                    break;
                }
            }
            if(!isFront) {
                frontwords.add(word);
                result++;
            }
        }
        System.out.println(result);
    }
}
