import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Test = Integer.parseInt(br.readLine());

        while(Test-- > 0){
            int N = Integer.parseInt(br.readLine());
            int [] tree = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N;i++){
                tree[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(tree);

            int[] newTree = new int[N];
            int left = (N-1)/2;
            int right = left+1;

            for(int i =0;i<N;i++){
                if(i%2 ==0){
                    newTree[i] = tree[left--];
                }
                else{
                    newTree[i] = tree[right++];
                }
            }
            int maxheight = 0;
            for(int i =0; i<N; i++){
                int nextIndex= (i+1) % N;
                maxheight = Math.max(maxheight,Math.abs(newTree[i] - newTree[nextIndex]));
            }
            System.out.println(maxheight);
        }
    }
}






