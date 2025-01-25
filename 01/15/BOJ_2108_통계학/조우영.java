import java.util.Arrays;
import java.util.Scanner;

public class Backjoon_2108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int N = sc.nextInt();
            if(N%2 != 0){
                int[] numbers = new int[N];
                for (int i = 0; i < N; i++) {
                    numbers[i] = sc.nextInt();
                }

                // 산술 평균
                int sum = 0;
                for (int number : numbers) {
                    sum += number;
                }
                System.out.println(Math.round((float) sum /numbers.length));

                // 중앙값
                while(true){
                    if(numbers.length!=1) {
                        int[] centerArray = Arrays.copyOf(numbers, numbers.length);
                        Arrays.sort(centerArray);
                        System.out.println(centerArray[N / numbers.length + 1]);
                    }else{
                        System.out.println(numbers[0]);
                    }
                    break;
                }

                // 최빈값
                int[] frequency = new int[8001];
                for (int number : numbers) {
                    frequency[number+4000] += 1;
                }
                int freMax=numbers[0];
                for (int i : frequency) {
                    if(freMax < i){
                        freMax = i;
                    }
                }
                System.out.println(freMax);

                // 범위
                int max=numbers[0];
                for (int number : numbers) {
                    if(max < number){
                        max = number;
                    }
                }
                int min=numbers[0];
                for (int number : numbers) {
                    if(min > number){
                        min = number;
                    }
                }
                System.out.println(Math.abs(max-min));


                break;
            }
        }


    }
}
