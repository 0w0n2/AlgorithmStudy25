import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseNum = Integer.parseInt(br.readLine());

        int[] levels = new int[caseNum];
        for (int i = 0; i < caseNum; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }

        int count=0; // 뺀 횟수
        int level=0;
        while(true){
            // 연속된 배열이 크거나 같으면 1빼기, count
            if(levels[level] >= levels[level+1]){
                levels[level] -= 1;
                count++;
            }
            level++; // 레벨 증가

            // 배열한바퀴 돌면 다시 검사
            if(level == levels.length-1){
                level=0;
            }

            // 오름차순이면 종료
            if(isClim(levels)){
                break;
            }
        }

        System.out.println(count);
    }

    private static boolean isClim(int[] arr) {
        // 오름차순이 아닌 경우
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}

