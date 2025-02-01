import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();

        // 양수는 오름차순, 음수는 내림차순으로 정렬하면, 절댓값이 가장 큰 수끼리 계산 가능해서 우선순위 큐 사용
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            // 받은값이 양수면 plus에 삽입, 아니면 minus에 삽입
            if(num > 0) plus.add(num);
            else minus.add(num);
        }

        int result = getSum(plus)+getSum(minus);
        System.out.println(result);
    }

    // 계산 메서드
    private static int getSum(PriorityQueue<Integer> arr) {
        // 계산한 큐를 넣기위한 큐
        Queue<Integer> q = new LinkedList<>();

        // 계산해서 새로운 큐에 삽입
        while(!arr.isEmpty()){
            int n = arr.poll();

            if(arr.isEmpty()) q.add(n); // 꺼낸게 마지막이면 그냥 더하기
            else{ // 그렇지 않으면 n과 곱해서 큐에 삽입(단, 둘중 하나가 1이면 더하는게 낫다)
                int next = arr.poll();
                if (n==1 || next==1){
                    q.add(n);
                    q.add(next);
                }
                else q.add(n*next);
            }
        }

        // 꺼내서 합하기
        int sum=0;
        while(!q.isEmpty()){
            sum += q.poll();
        }
        return sum;
    }

}

