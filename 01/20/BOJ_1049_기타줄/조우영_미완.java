import java.io.*;
import java.util.*;

public class baekjoon_1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        // 브랜드별 묶음, 낱개 금액 변수
        int[][] arr = new int[m][2];
        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 금액, 묶음 최소, 낱개 최소 초기화
        int price = 0;
        int setPrice = arr[0][0];
        int onePrice = arr[0][1];

        // 6개일때 브랜드별 최소값 배열
        int[] min = new int[m];

        // 끊어진 줄 개수(n)에 따른 구분
        if(n>6) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][0] < setPrice) {
                    setPrice = arr[i][0];
                }
            }
            price += setPrice;
            n -= 6;
        }else if(n==6){ // n이 6일때
            int minPrice = 0;
            for(int i=0;i<arr.length;i++){
                if(arr[i][0] > arr[i][1]*n){
                    minPrice = arr[i][1]*n;
                }
            }
            price += minPrice;
            n-=6;
        }else{
            for(int i=0;i<arr.length;i++){
                if(arr[i][1] < onePrice) {
                    onePrice = arr[i][1];
                }
            }
            price += onePrice*n;
            n=0;
        }
        System.out.println(price);

        br.close();
    }
}

