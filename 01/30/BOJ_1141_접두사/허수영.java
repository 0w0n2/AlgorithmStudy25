import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        List<String> strings = new ArrayList<>();

        for(int i=0; i<n;i++){
            strings.add(br.readLine());//문자열을 추가
        }
        Collections.sort(strings, Collections.reverseOrder());
        //내림차순 정렬
        List<String>result = new ArrayList<>();
        String previous="";
        for(String s : strings){//정렬된 문자열 반복
            if(!previous.startsWith(s)){ //현재문자열이
                result.add(s);          //이전 문자열로 시작x할때만 추가
                previous = s;          //현재 문자열을 이전문자열로
            }                         //이걸 반복

        }
        System.out.println(result.size());
        }
    }







