import java.io.*;
import java.util.*;


//블루레이의 최대는 레슨길이 합
//블루레이 개수가 n보다 많으면 줄임
public class Main_2343 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int lectures[]=new int[N];
        int maxLecture=0;
        int total=0;

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            lectures[i]=Integer.parseInt(st.nextToken());
            total+=lectures[i];
            maxLecture=Math.max(maxLecture,lectures[i]);
        }
        int left= maxLecture;//가장 긴 강의가 블루레이 최소
        int right=total;//모든 합이 블루레이 최대
        int result=total;
        while(left<=right){
            int mid = (left+right)/2;
            int count =1;
            int current=0;
            //강의를 블루레이에 담을거임
            for(int lecture:lectures){
                if(current+lecture >mid){
                    count++;//블루레이 추가요~
                    current=lecture;
                }
                else{
                    current+=lecture;
                }
            }
            if(count>M){
                left=mid+1;
            }
            else{
                result=Math.min(result,mid);
                right=mid-1;
            }

        }
        System.out.print(result);
    }


}

