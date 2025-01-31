import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] x = new int[M];
        int[] y = new int[M];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            x[i]=Integer.parseInt(st.nextToken());
            y[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(x);
        Arrays.sort(y);

        int medianX=x[M/2];
        int medianY=y[M/2];

        int minDistance=0;

        for(int i=0; i<M; i++){
            minDistance += Math.abs(x[i] - medianX) + Math.abs(y[i]- medianY);
        }
        System.out.println(minDistance);
        }
    }



//쉬운데 중앙값을 생각못함ㅌㅌ



