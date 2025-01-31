import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine()); //레벨 수
      int[] arr = new int[N];
      int count=0;                             //감소 횟수 
      for (int i=0; i<N;i++ ){
          arr[i]=Integer.parseInt(br.readLine()); //배열에 값 입력
      }
      for(int i=N-2; 0<=i;i--){                  //역순으로 진행
          if(arr[i]>=arr[i+1]){                  // 다음 값보다 크다면 
              count+= arr[i]-arr[i+1]+1;        // 현재 값- 다음값+1 만큼 낮춰줘야하므로 감소횟수가 됨
              arr[i] = arr[i+1]-1;               //반복하기 위해 현재 인덱스를 다음 인덱스보다 1낮춰줌 
          }
      }
      System.out.println(count);
      }
    }
