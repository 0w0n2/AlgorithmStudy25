import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 에라토스테네스의 체 : 2~N까지 소수의 배수들을 다 걸러버림으로써 소수만 남기는 방식

        int max = 1000;
        boolean[] isPrime = new boolean[max+1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        ArrayList<Integer> prime = new ArrayList<>();

        /*
        for (int i=2; i<=max; i++){
            if (isPrime[i]) prime.add(i);
            for (int j=i*2; j<=max; j+=i) isPrime[j] = false;
        }
        for (int i=0;i<prime.size();i++) System.out.print(prime.get(i)+" ");
         */


        for (int i=2; i<=max; i++){
            if (isPrime[i]) prime.add(i);
            for (int j=i*i; j<=max; j+=i) isPrime[j] = false;
        }
        for (int i=0;i<prime.size();i++) System.out.print(prime.get(i)+" ");

    }
}
