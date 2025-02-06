import java.util.*;
import java.io.*;

class B_1654{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // k랜선 배열 생성
        int[] arr = new int[k];
        for(int i=0;i<k;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        // start, mid, end 지정
        int start=0;
        int end=arr[k-1];
        int mid=(start+end)/2;
        int sum = 0;

        while(start<end) {
            mid = (start+end)/2;
            sum=0; // sum 초기화

            // mid로 나누고 난 랜선 갯수를 다 더함
            for(int i=0;i<arr.length;i++) {
                sum += arr[i]/mid;
            }

            // sum이 n개인 경우의 최대값을 찾아야하므로 end값을 mid로 잡고 나중에 -1
            if(sum<n) end = mid-1;
            else start = mid+1;

        }
        System.out.println(mid);
    }
}

