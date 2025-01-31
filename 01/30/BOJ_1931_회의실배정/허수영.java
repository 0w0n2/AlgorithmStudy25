import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long meetings [][] = new long[n][2];

        for(int i =0; i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0]=Long.parseLong(st.nextToken());
            meetings[i][1]=Long.parseLong(st.nextToken());

        } //2차원 배열인데 comparator은 1차원 배열에 최적
        //Arrays.sort(meetings, Comparator.comparing(m -> m[1]).thenComparing(m -> m[0]));
        Arrays.sort(meetings, new Comparator<long[]>(){
            public int compare(long[] m1, long[] m2){
                if(m1[1] == m2[1]){
                    return Long.compare(m1[0],m2[0]);
                } //종료 시간이 같으면 시작시간 비교,아니면 종료시간 비교
                return Long.compare(m1[1],m2[1]);
            }
        });
        int count=0;
        long end=0;
        //현재 회의 시작 시간이 전 회의보다 크거나 같으면?
        for(long[] meeting : meetings){
            if(meeting[0]>= end){
                count++;
                end=meeting[1];
            }
        }
        System.out.println(count);
        }

    }







