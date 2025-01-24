import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력 단순해서 그냥 스캐너로 받음
        int n = sc.nextInt(), k = sc.nextInt();
        int count = 0; // 제거한 횟수 세는 변수

        ArrayList<Integer> numList = new ArrayList<>(); // 지워야한다길래 ArrayList 썼습니다... 직관적으로
        for (int i=2; i<=n; i++) numList.add(i); // 2부터 n까지 리스트에 숫자 채워넣기

        while(!numList.isEmpty()){ // 요소가 모두 삭제될 때까지(텅 빔) 반복문 실행 ← 기본 조건으로 적은 것뿐이고 그 전에 count==k 도달해서 return 될 듯
            int num = numList.get(0); // 현재 요소 중 가장 앞에 있는 거 빼오기(소수)
            count++;         // .remove()로 제거하기 전 카운트 + k값에 도달했는지 체크
            if (count==k){
                System.out.println(num);    // 도달했으면 출력 후 바로 종료
                return;
            }
            numList.remove(0);      // 가장 첫번째 요소 제거

            for (int i=0; i<numList.size(); i++){ // 리스트의 0번부터 ~ 리스트 끝까지 살피면서 num의 배수인 거 찾으면 카운팅 → k 체크 → 해당 배수 제거
                if (numList.get(i)%num==0){
                    count ++;
                    if (count==k){
                        System.out.println(numList.get(i));
                        return;
                    }
                    numList.remove(i);
                }
            }
        }
    }
}

