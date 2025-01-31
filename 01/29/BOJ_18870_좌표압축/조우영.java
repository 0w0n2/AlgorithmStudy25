import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] copyArr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            copyArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(copyArr);

        // 인덱스 배열 생성
        int len = arr[arr.length-1]-arr[0]; // -10 ~ 4 : 14, -10=0번, 4=14번
        int[] indexArr = new int[len+1];
        for (int i = 0; i < n; i++) {
            // 0 1 12 14 14
            indexArr[arr[i]-10] =+ 1;
            // [1,1,0,0,0,0,0,0,0,0,0,0,1,0,2]
        }

        // 새 배열에 정렬
        int[] newArr = new int[n];
        newArr[0] = arr[0];
        for (int i = 1; i < n; i++) {
            if(newArr[i] != newArr[i-1]){
                newArr[i] = arr[i];
            }
            // 이전 데이터와 같으면
            newArr[i] = newArr[i-1];
        }

        for (int i : newArr) {
            System.out.print(i + " ");
        }
    }
}

