import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result [] = compression(arr);//압축 슈웃

        for(int i : result){
            System.out.print(i + " ");
        }

    }
    public static int [] compression(int[] arr){
        int [] unique = Arrays.stream(arr).distinct().sorted().toArray();
        //중복을 제거하고 정렬함
        Map<Integer, Integer> index = new HashMap<>();
        for(int i=0; i<unique.length; i++){
            index.put(unique[i],i);
        }//그 후 그 값과 인덱스를 매핑할거임
        int [] compress = new int[arr.length];
        for(int i =0; i<arr.length;i++){
            compress[i]=index.get(arr[i]);
        } //매핑한 인덱스를 토대로 배열로 슈웅
        return compress;
    }
}






