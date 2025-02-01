import java.util.*;
import java.io.*;
//배열에 넣고
//bfs사용해서 모든 값들의 합들을 구하고
//나오지않는 최솟값 찾으면 끝으로 추정
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[]totals = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            totals[i]=Integer.parseInt(st.nextToken());
        }
        HashSet<Integer>totalSum = new HashSet<>();
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        totalSum.add(0);

        for(int total:totals){
            HashSet<Integer>currentSum = new HashSet<>(totalSum);
            for(int sum:currentSum){
                totalSum.add(sum+total);
            }
        }
        int ans=1;
        while(totalSum.contains(ans)){
            ans++;
        }
        System.out.println(ans);
        }

    }
//딴사랑 코드 보고 느낀점:
//시간복잡도 손해봄.. bfs복습했으니 이득..
//백준에서 메모리초과 주륵 
//남들 코드 참고해야할듯 hashset문제 추정
//수정예정 





