import java.io.*;
import java.util.*; //문자는 짝수or한놈은 홀수가능(근데 가운데)

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        int count [] = new int[26];
        for(char c: str.toCharArray()){ //알파벳 개수세기
            count[c - 'A']++; //각 문자를 0~25까지 매핑
        }
        StringBuilder sb = new StringBuilder();
        char odd =0;
        boolean checkodd = false; //홀수 개수 확인
        
        for (int i=0; i<26; i++){
            if(count[i] %2 ==1){
                if(checkodd){
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                odd=(char)(i+'A'); 
                checkodd=true;//홀수 문자 발견
            }
            for(int j =0; j<count[i]/2;j++){ //절반을 저장 복사해서 뒤집으면 됨
                sb.append((char)(i+'A'));
            }
        }
        StringBuilder drome = new StringBuilder(sb);
        if(checkodd){
            drome.append(odd);//홀수 개수 문자를 가운데에 넣어버림
        }
        drome.append(sb.reverse()); //그리고 뒤집은놈 추가함
        System.out.println(drome.toString());
    }
}
