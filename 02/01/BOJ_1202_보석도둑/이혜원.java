import java.io.*;
import java.util.*;

public class Main {
    static int [] bag;
    static int [][] diamond;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        System.out.print(solve());
        // O(nlog n) + O(klog k) + O(klog n)
    }

    static long solve(){ // O(klog n) + O(nlog n)
        long sum = 0L;
        PriorityQueue<Integer> v = new PriorityQueue<>(Comparator.reverseOrder()); // 현재 가방에 들어갈 수 있는 보석 대기열, 비싼 순 정렬(가치 내림차순)
        int j = 0;
        for (int i=0;i<k;i++){ // 가방 선택 // O(k)... -> 바디까지 O(klog n) + O(nlog n)
            for (; j<n && diamond[j][0]<=bag[i]; j++){ // 모든 k를 통틀어 n번만 수행 -> 바디까지 n(log n)
                v.offer(diamond[j][1]); // 큐 삽입 연산 O(log m) ... 최악의 경우 m = n 이므로 O(log n)
            }
            if (!v.isEmpty()) sum += v.poll(); // 큐 연산 O(log m) ... O(log n)
        }
        return sum;
    }

    static void input(BufferedReader br) throws IOException{ // O(n) + O(nlog n) + O(k) + O(klog k)
        StringTokenizer st = new StringTokenizer(br.readLine()); // n, k
        n = Integer.parseInt(st.nextToken()); // 보석 개수
        k = Integer.parseInt(st.nextToken()); // 가방 개수

        bag = new int[k]; // 가방 무게 저장
        diamond = new int[n][2];

        for (int i=0;i<n;i++){ // (O(n)
            st = new StringTokenizer(br.readLine()); // n개 줄에 보석 무게(m),(v) 주어짐
            diamond[i][0] = Integer.parseInt(st.nextToken());
            diamond[i][1] = Integer.parseInt(st.nextToken()); // {무게, 가치} 입력
        }
        Arrays.sort(diamond, (o1, o2) -> o1[0]-o2[0]); // 가벼운 순(무게 오름차순) // O(nlog n)

        for (int i=0;i<k;i++) bag[i] = Integer.parseInt(br.readLine()); // O(k)
        Arrays.sort(bag); // 가방 무게 오름차순 // O(klog k)
    }
}

