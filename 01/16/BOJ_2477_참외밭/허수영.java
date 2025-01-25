import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        
        int k =Integer.parseInt(br.readLine());
        int maxW=0;
        int maxH=0;
        int arr[]=new int[6];
        int maxWI=0;
        int maxHI=0;
        
        
        for(int i=0;i<arr.length;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            arr[i]=Integer.parseInt(st.nextToken());
            
            if(n==1 || n==2){
               if(arr[i]>maxW){
                   maxW=arr[i];
                   maxWI=i; //W의인덱스값
               }
                //   maxW=Math.max(maxW,arr[i]); //최대가로
            }
            else if (n==3 || n==4){
               if(arr[i]>maxH){
                   maxH=arr[i];
                   maxHI=i;//H의 인덱스값
               }
                //maxH=Math.max(maxH,arr[i]);//최대세로
            }
        }   /// 여기까진 입력 받기 + 최댓값 구하기
        
        int H1 = (maxHI+5)%6;  // 최댓값 인덱스의 양 옆 인덱스를 구하자    
        int H2 = (maxHI+1)%6;
        int W1 = (maxWI+5)%6;
        int W2 = (maxWI+1)%6;
           
        int emptyH=Math.abs(arr[H1]-arr[H2]);
        int emptyW=Math.abs(arr[W1]-arr[W2]);   
        
         System.out.println(maxW*maxH-emptyH*emptyW);
        }
    }

