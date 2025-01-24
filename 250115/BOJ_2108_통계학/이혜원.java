import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // N개의 수
        HashMap<Integer, Integer> map = new HashMap<>(); // 최빈도 측정용

        int [] num = new int [n];
        int sum = 0; // 평균 용

        for (int i=0;i<n;i++) {
            num[i] = Integer.parseInt(br.readLine());
            sum += num[i]; // 입력과 동시에 평균을 구하기 위한 총계 계산

            if (map.containsKey(num[i])) map.replace(num[i], map.get(num[i]) + 1); // 이미 등록된 Key라면(입력 숫자라면) 해당 Value 값을 +1 해준다
            else map.put(num[i], 1); // 처음 등록하는 Key(입력 숫자)라면 Value에 1을 넣어준다(1개)
        }
        Arrays.sort(num); // 중앙값,범위 위해 오름차순 정렬

        System.out.println(Math.round((double) sum / num.length) + "\n" + num[num.length / 2]);  // 산술 평균(첫째자리 반올림), 중앙값

        // 최빈값
        int max = 0;
        for (Integer i : map.keySet()) max = Math.max(max, map.get(i));  // 맵에서 가장 큰 빈도 값 찾아줌

        ArrayList<Integer> mapAL = new ArrayList<>();   // 가장 큰 빈도에 해당하는 key(숫자)값들을 저장하기 위한 ArrayList
        for (Integer i : map.keySet()) if (map.get(i)==max) mapAL.add(i);  // 만약 가장 큰 빈도에 해당한다면 key(숫자)를 ArrayList에 저장

        if (mapAL.size()==1) System.out.println(mapAL.get(0)); // ArrayList size가 1이다 => 최빈값 여러개 X
        else { // 최빈값이 여러개일 경우, 두번째로 작은 수 출력
            Collections.sort(mapAL); // 오름차순 정렬
            System.out.println(mapAL.get(1)); // 두번째로 작은 수(인덱스 1) 출력
        }

        System.out.println(num[num.length-1]-num[0]); // 범위 차
    }
}

