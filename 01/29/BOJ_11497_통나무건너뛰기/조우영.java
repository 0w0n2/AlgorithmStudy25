import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        for (int i = 0; i < test; i++) {
            int number = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[number]; // 입력받을 배열
            int[] newArr = new int[number]; // 정렬시킬 배열

            // 배열에 숫자 입력
            for (int j = 0; j < number; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            // 새로운 배열에 정렬
            int left = 0;
            int right = number-1;
            for (int j = 0; j < number; j++) {
                if(j%2==0){
                    newArr[left] = arr[j];
                    left++;
                }else{
                    newArr[right] = arr[j];
                    right--;
                }
            }

						// 각 연결된 데이터의 차의 최대값 구하기
            int min=Math.abs(newArr[0]-newArr[1]);
            for (int j = 1; j < number; j++) {
                min = Math.max(min, Math.abs(newArr[j]-newArr[j-1]));
            }

            System.out.println(min);
        }
        br.close();
    }
}

