import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // 사람 수
        int [] weight = new int[n]; // 무게 저장
        int [] height = new int[n]; // 키 저장
        for (int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            height[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0;i<n;i++){  // i번째 사람의 랭킹을 검사
            int rank = 1;     
            for (int j=0;j<n;j++){ // 1. 모든 사람(본인 제외)를 검사해서
                if (j==i) continue;
                if (weight[i]<weight[j] && height[i]<height[j]) rank++;
                // 2. 만약 나보다 키, 몸무게가 모두 큰 사람(j)가 있으면 나의 랭크는 1씩 뒤로 밀린다
            }
            bw.write(String.valueOf(rank)+" "); 
        }

        bw.flush();
        bw.close();
    }
}

