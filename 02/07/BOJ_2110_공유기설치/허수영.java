import java.io.*;
import java.util.*;

public class Main_2110 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int C= Integer.parseInt(st.nextToken());
        int arr []=new int[N];

        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int left=1;
        int right=arr[N-1]-arr[0]; //최대 거리
        int result=0;
        while(left<=right){
            int mid =(left+right)/2; //현재 간격을 이만큼으로 정하고
            int count=1;
            int start=arr[0];

            for(int i=1; i<arr.length;i++){
                if (arr[i]-start>=mid){//간격으로 C개이상 공유기
                    start=arr[i];//설최되는지
                    count++;
                }
            }
            if(count>=C){//개수가 c개 이상이다?
                left=mid+1;//그럼 거리를 더 늘려야함
                result=mid;

            }
            else{
                right=mid-1;//아니면 거리 낮춰야함
            }
        }
        System.out.println(result);
    }
}

