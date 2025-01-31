import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int t=1; t <= testCase; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] listN = new int[N][2];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                listN[i][0] = Integer.parseInt(st.nextToken());
                listN[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(listN, (o1, o2) -> {          // 서류심사 성적을 오름차순으로 정렬한다.
                return o1[0]-o2[0];                   // 자동으로 서류심사 성적은 반복문안에서 분류됨
            });

            int result = 0;                         
            int minY = Integer.MAX_VALUE;
            for(int i = 0; i < N; i++) {                // for문을 처음부터 돌리면서 면접성적의 최소값을 저장한후
                minY = Math.min(minY, listN[i][1]);     // 면접 성적의 최소값이 해당사람의 성적보다 낮다면 해당 사람의
                if(i >= 1 && listN[i][1] > minY) result++; //두 성적보다 높은 등수를 가진 사람이 있다는 뜻임.
            }
            System.out.println(N - result);
        }
    }
}
// 주석 더 필요하면 말해주세요..
