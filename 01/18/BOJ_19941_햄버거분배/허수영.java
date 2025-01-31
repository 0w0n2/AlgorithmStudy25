import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine()," ");

      int N=Integer.parseInt(st.nextToken());
      int K=Integer.parseInt(st.nextToken());

      char [] arr = new char[N];

      String str = br.readLine();
      for(int i=0; i<N; i++){
          arr[i]=str.charAt(i);  //각 문자를 인덱스에다가 넣음
      }
      int count =0;    //몇명이 햄버거 먹지

      for(int i=0; i<N; i++){  //배열 전부 훑어
          if(arr[i] == 'P'){ //사람이다?
              for(int j= Math.max(0,i-K); j<=Math.min(N-1,i+K);j++){ //-K부터K까지 훑기 인덱스0~19사이에서
                 if(arr[j]=='H'){ //햄버거 찾아
                     arr[j] = ' '; //없애버리고
                     count++; //개수 올려
                     break; //인당 1개만 가능
                 }
              }
          }
      }
    System.out.println(count);
    }
    }

