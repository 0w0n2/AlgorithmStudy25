import java.io.*;
import java.util.StringTokenizer;
//상한가 구하기 문제임
//배열에 있는 값 합쳐서
//3번째 입력값보다 낮게 만들기
//배열을 정렬시킨후 크면은 오른쪽 작으면 왼쪽(이진탐색)
//해서 중앙값을 빡해야함
public class Main_2512 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int left=0; //왼쪽
        int right=0;//오른쪽
        int arr[]=new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            right=Math.max(right,arr[i]);
        }//오른쪽에 최댓값

        int total=Integer.parseInt(br.readLine());//총 합계값 받고
        int answer=0;
        while(left<=right){
            int mid = (left+right)/2; //중앙값잡고
            int sum=0;

            for(int i=0; i<N; i++){
                sum+= Math.min(arr[i],mid);//금액이 크면 미드값을 넣어버림
            }//상한액보다 크면

            if(sum<=total){
                answer=mid;
                left=mid+1;
            }
            else{
                right=mid-1;//무빙시켜서 반복
            }

        }
        System.out.println(answer);


    }
}

