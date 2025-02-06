package backjoon;
import java.io.*;
import java.util.*;
//lower
//higher
//mid 구해서 찾아나가야함 중앙위치 값을 기준으로 비교한후 상한 내리냐 하한 올리냐
//N의 개수에 따른 특정 길이를 찾아야함
//중간 길이로 잘라서 몇개 만들어졌는지 구하고
//그걸보고 길이 조정 하면서 만들어진 개수 반복
public class Main_1654 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());
        int max=0;
        int[] arr = new int[K];
        for(int i=0; i<K;i++) {
            arr[i]=Integer.parseInt(br.readLine());
            max=Math.max(max,arr[i]);
        }
        int min=1;
        int result=0;
        while(min<=max) {
            int mid=(min+max/)2;
            int count=0;

            for(int i=0; i<arr.length;i++) {
                count+=arr[i]/mid;
            }
            if(count==N) {
                x=mid;
                x=Math.max(x, mid);
                min =mid+1;
            }
            else if (count>N) {
                min= mid+1;
                mid=Math.max(x, mid)
            }else {
                max=mid-1

            }

        }


    }

}

