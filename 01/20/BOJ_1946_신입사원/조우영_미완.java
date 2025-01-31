import java.io.*;
import java.util.*;

public class baekjoon_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test_case = Integer.parseInt(br.readLine());
        for(int i=0;i<test_case;i++){
            int sup = Integer.parseInt(br.readLine());

            // 지원자
            int[][] arr = new int[sup][2];
            for(int j=0;j<arr.length;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }

            // 랭크 배열 생성후 1 할당
            int rank[] = new int[sup];
            for (int j = 0; j < rank.length; j++) {
                rank[j] = 1;
            }

            // row,col둘다 작으면 해당인덱스 rank++
            for(int j=0;j<arr.length;j++){
                for(int k=0;k<arr.length;k++){
                    if(j!=k){
                        if(arr[j][0]>arr[k][0] && arr[j][1]>arr[k][1]){
                            rank[j]++;
                        }
                    }
                }
            }

            int max=rank[0];
            int count = 0;
            for (int i1 : rank) {
                if(max < i1){
                    count++;
                }
            }
            System.out.println(sup - count);
        }

        br.close();
        bw.close();

    }
}

