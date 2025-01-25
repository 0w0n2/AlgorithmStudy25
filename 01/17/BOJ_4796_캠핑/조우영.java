import java.io.*;

class Main {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseNum=1;
        while(true) {
            String[] inputs = br.readLine().split(" ");
            int l=Integer.parseInt(inputs[0]);
            int p=Integer.parseInt(inputs[1]);
            int v=Integer.parseInt(inputs[2]);

            // 0세개를 받으면 종료
            if(l==0&&p==0&&v==0) {
                break;
            }

						// 나머지와 사용일수 중 작은 것 사용.
            int day = v/p*l + (v%p > l ? l : v%p);

            System.out.println("Case "+caseNum+": "+day);
            caseNum++;
        }

        br.close();
    }
}
