import java.util.*;
import java.io.*;
//배열만큼 받음
//배열에 값넣고
//2이상인 수를 새 배열에 담고
//max값 2개를 곱해서 sum에 다가 더함 (내림차순해서 하면 됨)
//배열 수가 1개이하가 될때까지 반복
//남은수가 있으면 더하고
// 1이하인 수들이 있는 배열의 값들을 전부 더함(음수개수가 짝수이면 곱하는게 이득이네)
// 음수가 남아있는데 0이 있다면 곱해버리면 0이됨
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0; i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        System.out.println(maxSum(arr));


        }

        public static int maxSum(int[] arr){
        int total=0;
        int positives[] = new int[arr.length];
        int negatives[] = new int[arr.length];
        int zeroCounts=0;
        int oneCounts=0;
        int plusi=0;
        int minusi=0;
        for(int num:arr){
            if(num>1){
                positives[plusi++] = num;
            }
            else if(num ==1){
                oneCounts+=1;
            }
            else if(num==0){
                zeroCounts+=1;
            }
            else{
                negatives[minusi++]=num;
            }//2이상인 수 담았고 1따로 담았고 0따로 담고 마이너스 담았고
        }//2이상인수는 걍 순차적으로 곱해서 더하고
        //하나 남으면 더하고 1더하고 , 마이너스 곱해서 더하고
        //마이너스가 1개가 남았는데 0이있으면 곱해버리고
        Arrays.sort(positives,0,plusi);
            for(int i=plusi-1; i>0;i-=2){
            total += positives[i] * positives[i-1];
        }
        if (plusi % 2 ==1){
            total += positives[0];
        }
        total += oneCounts;

        Arrays.sort(negatives,0,minusi);
        for(int i=0;i<minusi-1;i+=2){
            total += negatives[i]*negatives[i+1];
        }
        if(minusi % 2 ==1 ){
            if(zeroCounts==0){
                total+=negatives[minusi-1];
            }
        }

        return total;
        }

    }
//딴 사람보고 느낀점: 아 arraylist써서 동적으로 할당받았으면
//더 편했겠다..
//해서 Collections.reverseOrder써버릴걸 내껀 객체배열아니라서 안됨





