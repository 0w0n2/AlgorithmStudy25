import java.io.*;
import java.util.*;

public class Main {
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> p =  new ArrayList<>(); // 양수 담기 용(내림차순 정렬)
        ArrayList<Integer> m = new ArrayList<>(); // 음수 담기 용(오름차순 정렬)
        boolean isZero = false; // 0이 존재하는가

        for (int i=0;i<n;i++){ // O(n)
            int num = Integer.parseInt(br.readLine());

            if (num==0) isZero = true;
            else if (num==1) sum++;
            else if (num<0) m.add(num);
            else p.add(num);
        }

        if (!p.isEmpty()){
            Collections.sort(p, Collections.reverseOrder()); // O(mlog m) ※ m은 p.size() 최악의 경우 m=n -> O(nlogn)
            makeSum(p, p.size()); // 최악의 경우 O(n)
        }

        if (!m.isEmpty()) {
            Collections.sort(m); // O(nlogn)
            if (m.size()%2==1 && isZero) m.add(0);
            makeSum(m, m.size()); // 최악의 경우 O(n)
        }

        System.out.print(sum);
        // O(nlogn)
    }

    public static void makeSum(ArrayList<Integer> p, int size){
        int midSum = 0;

        for (int i=0;i<size;i++){ // O(size)
            if (i%2==0) {
                midSum+=p.get(i);
                if (i==(size-1)) sum += midSum;
            }
            else {
                midSum *= p.get(i);
                sum += midSum;
                midSum = 0;
            }

        }
    }
}

