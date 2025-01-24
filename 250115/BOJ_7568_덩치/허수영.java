import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n =Integer.parseInt(br.readLine());
        int arr[][]= new int[n][2];
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());            
        }
        for(int i=0; i<n; i++){
                    int count=1;
// for (int j=i+1; j<n; j++로 생각했는데 int count를 바깥쪽 for문에서 초기화 해주므로 0부터했어야했음)
            for(int j= 0; j<n; j++){
                if((arr[i][0] < arr[j][0]) && (arr[i][1]<arr[j][1])){
                    count +=1;
        }
            }
        sb.append(count).append(" ");
        
    }
        System.out.println(sb);
}
}
