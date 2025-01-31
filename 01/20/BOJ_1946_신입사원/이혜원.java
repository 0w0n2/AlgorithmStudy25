import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i=0;i<testCase;i++){
            int p = Integer.parseInt(br.readLine());
            int [][] rank = new int[p][2];
            for (int j=0;j<p;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                rank[j][0] = Integer.parseInt(st.nextToken());
                rank[j][1] = Integer.parseInt(st.nextToken());
            }

            // "다른 모든 지원자와 비교했을 때" 두 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발
            // 서류 심사 순위를 기준으로 정렬된 면접 시험 순위 순서를 자기보다 앞쪽에 있는 사람(서류 심사 순위가 높은)보다 우수해야 함
            Arrays.sort(rank, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });
            int c = 1;
            int small = rank[0][1];
            for (int j=1;j<p;j++){      // 서류 순위 2등부터 체크(서류 순위 1위는 무조건 통과)
                if (rank[j][1]<small) { // 자기보다 앞쪽에 있는 사람보다 면접이 우수하다면 통과
                    c++;
                    small = rank[j][1]; // 다음 사람이 비교할 때, 그 사람의 앞쪽 중 가장 우수한 성적이 됨
                }
            }
            bw.write(String.valueOf(c)+"\n");
        }
        bw.flush();
        bw.close();
    }
}

