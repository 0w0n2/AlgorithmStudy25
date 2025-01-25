import java.io.*;
import java.util.*;

class Main{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());

        //동서남북 배열 정의
        ArrayList<Integer> east = new ArrayList<>();
        ArrayList<Integer> west = new ArrayList<>();
        ArrayList<Integer> south = new ArrayList<>();
        ArrayList<Integer> north = new ArrayList<>();

        // 입력 받기
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int length = Integer.parseInt(input[1]);

        // 입력 받은 만큼 숫자에 맞는 배열에 추가
        switch(n) {
            case 1:
                east.add(length);
                break;
            case 2:
                west.add(length);
                break;
            case 3:
                south.add(length);
                break;
            case 4:
                north.add(length);
                break;
        }

        // 방향별 길이 최대값 배열
        int[] lengths = new int[4];

        compass(lengths, east, 0); // length[0]에 받은 east최대값
        compass(lengths, west, 1); // length[1]에 받은 west최대값
        compass(lengths, south, 2); // length[2]에 받은 south최대값
        compass(lengths, north, 3); // length[3]에 받은 north최대값

        // 큰 사각형
        int bigWidth = lengths[(lengths[0] > lengths[1]) ? 0 : 1];
        int bigHeight = lengths[(lengths[2] > lengths[3]) ? 2 : 3];

        // 작은 사각형
        smallSquare(east, west);

        bw.flush();
        br.close();
        bw.close();
    }

    private static void smallSquare(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
    }

    public static void compass(int[] lengths, ArrayList<Integer> arr, int n){
        int max =lengths[0];
        for(int num : arr) {
            if(max<num){
                max = num;
            }
        }
        lengths[n] = max;
    }
}
