import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> stack = new ArrayList<>(); // ArrayList를 이용해서 스택처럼 구현하기
        
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            String command = st.nextToken();
            
            if (command.equals("push")) { // push 명령어
                int a = Integer.parseInt(st.nextToken());
                stack.add(a);
            } 
            else if (command.equals("pop")) { // pop 명령어
                if (!stack.isEmpty()) {
                    System.out.println(stack.remove(stack.size() - 1));
                } else {
                    System.out.println(-1);
                }
            } 
            else if (command.equals("top")) { // top 명령어
                if (!stack.isEmpty()) {
                    System.out.println(stack.get(stack.size() - 1));
                } else {
                    System.out.println(-1);
                }
            } 
            else if (command.equals("empty")) { // empty 명령어
                if (stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } 
            else { // size 명령어
                System.out.println(stack.size());
            } 
        }
    }
}
