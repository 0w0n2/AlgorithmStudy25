import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] sortArr = new int[N];
        for(int i=0; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sortArr[i] = arr[i];
        }

        Arrays.sort(sortArr);

        Map<Integer, Integer> rankMap = new HashMap<>();   // 딕셔너리를 이용해서 값마다 랭크를 설정함.(중복제거)
        int rank = 0;
        for( int value : sortArr) {
            if(!rankMap.containsKey(value)) {
                rankMap.put(value, rank++);
            }
        }

        for (int value : arr) {
            sb.append(rankMap.get(value)).append(" ");  // 바로 print하면 시간복잡도 오류
        }
        System.out.println(sb.toString());
    }
}

