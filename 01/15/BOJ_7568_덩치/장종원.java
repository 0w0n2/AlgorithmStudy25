import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] array_data = new int[n][2];
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());   // 키, 몸무게 이차원 배열
            array_data[i][0] = Integer.parseInt(st.nextToken());
            array_data[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < n; i++) {                  // 나보다 키, 몸무게가 높은 인원수 + 1이 등수가 됨
            for (int j = 0; j < n; j++) {        
                if (i != j && array_data[i][0] < array_data[j][0] && array_data[i][1] < array_data[j][1]) {
                    result[i]++;       
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print((result[i] + 1) + " ");
        }
    }
}
