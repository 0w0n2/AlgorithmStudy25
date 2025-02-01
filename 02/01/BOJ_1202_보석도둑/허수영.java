import java.util.*;
import java.io.*;
// N과 K를 받고
//N번 만큼 보석의 무게와 가격을 받고
//K번 만큼 가방 무게를 받은 후
// 가방 무게를 내림차순하고 (왜 이리생각했뜨라?
//그 후 보석에서 가격이 높은순으로 내림차순 하고
// 그 중 가방무게 보다
//낮은 거를 가방에 넣어면 될듯
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()); //보석 수
        int K=Integer.parseInt(st.nextToken()); //가방 수

        int jewel[][] = new int[N][2]; //보석

        for(int i=0; i<N; i++){
            st= new StringTokenizer(br.readLine());
            jewel[i][0]=Integer.parseInt(st.nextToken()); //보석무게
            jewel[i][1]=Integer.parseInt(st.nextToken());//보석 가격

        }
        int[] bagWeights = new int[K];
        for(int i=0; i<K;i++){
            bagWeights[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(bagWeights);
        Arrays.sort(jewel,(a,b)-> b[1] - a[1]);//가격순으로 정렬

        int total=0;
        boolean[] used= new boolean[N];
            for(int bagweight:bagWeights){
                for(int j=0; j<N; j++){
                    if(!used[j] && jewel[j][0]<=bagweight){
                        total+=jewel[j][1];
                        used[j]=true;
                        break;
        }

                }
            }

        System.out.println(total);
    }

    }


//느낀점: 시간복잡도 잘 생각해야함..
//걍 느끼는대로 풀었음
//답잘나옴 시간초과해벌림
//시간 10초였어도 간당간당했음
//큐를 사용해서 단축예정..


