import java.io.*;
import java.util.*;

public class B_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        ArrayList<Character> input = new ArrayList<>();
        for (char c : s.toCharArray()) {
            input.add(c);
        }

        boolean a = true;
        // 처음 -나오면 '(' 그다음 -나오면 ')',
        for (int i=0;i<input.size();i++) {
            // a가 참이면 '(' 아니면 ')'
            char par = a ? '(' : ')';
            if(input.get(i).equals("-") && a){
                input.add(i+1, par);
                a = false;
                i++; // 추가됐으니 배열인덱스 1추가
            }
            a=true;

            // '('상태인데 배열끝에 도달하면 ')' 마무리 하기
            if(a==false && i==input.size()-1){
                input.add(i, par);
            }
        }

        System.out.println(input);


    }
}

