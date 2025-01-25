import [java.io](http://java.io/).*;
import java.util.*;

//방문 배열 체크 리스트 배열을 만들고,인접리스트를 생성해야함
public class Main {
static long A, K;
static long count[]; //
static boolean visit[]; //방문체크배열
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    A = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    count = new long[1000001];
    visit = new boolean[1000001];
    BFS((int)A); //A부터 탐색 슈웅
    System.out.println(count[(int)K]);//얼마나 걸린지 확인

}

static void BFS(int x) {
    Queue<Long> queue = new LinkedList<>(); //bfs에서는 linked 선호
    queue.add((long)x);
    visit[x] = true;

    while (!queue.isEmpty()) {
        long current = queue.poll(); //큐에서 현재 어디인지 보기 위해 꺼냄

        if (current + 1 <= 1000000 && !visit[(int)(current + 1)]){ //배열초과 + 방문x면
            queue.add(current + 1); //큐에 추가
            visit[(int) (current + 1)] = true;
            count[(int) (current + 1)] = count[(int) current] + 1; //이동횟수 +1
        }
        if (current * 2 <= 1000000 && !visit[(int)(current * 2)]){
            queue.add(current * 2);
            visit[(int) (current * 2)] = true;
            count[(int) (current * 2)] = count[(int) current] + 1; //위랑 똑같음 대신 *2만큼 가는거

        }

    }
}

}
