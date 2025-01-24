import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] list_n = new int[n];
        int[] count_list = new int[8001]; // 최빈값 계산용
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            list_n[i] = Integer.parseInt(br.readLine());
            sum += list_n[i];
            count_list[list_n[i] + 4000]++;
            max = Math.max(max, list_n[i]);
            min = Math.min(min, list_n[i]);
        }

        Arrays.sort(list_n);

        System.out.println(mean(sum, n));          // 평균
        System.out.println(median(list_n));       // 중앙값
        System.out.println(mode(count_list));     // 최빈값
        System.out.println(max - min);            // 범위
    }

    // 평균 계산
    public static int mean(int sum, int n) {
        return (int) Math.round((double) sum / n);
    }

    // 중앙값 계산
    public static int median(int[] list_n) {
        return list_n[list_n.length / 2];
    }

    // 최빈값 계산
    public static int mode(int[] count_list) {
        int maxCount = 0;  // 최대 빈도수
        List<Integer> modes = new ArrayList<>();

        for (int i = 0; i < count_list.length; i++) {
            if (count_list[i] > maxCount) {
                maxCount = count_list[i];
                modes.clear();
                modes.add(i - 4000);
            } else if (count_list[i] == maxCount) {
                modes.add(i - 4000);
            }
        }

        if (modes.size() > 1) {
            Collections.sort(modes);
            return modes.get(1);  // 두 번째로 작은 최빈값 반환
        }
        return modes.get(0);
    }
}
