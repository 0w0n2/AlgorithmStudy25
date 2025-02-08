import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger[] arr = new  BigInteger[251];
        arr[0] = BigInteger.valueOf(1); // 아무것도 안채우는 방법 1가지 ;;
        arr[1] = BigInteger.valueOf(1);
        arr[2] = BigInteger.valueOf(3);

        for(int i = 3; i <= 250; i++) {
            arr[i] = arr[i - 1].add(arr[i - 2].multiply(BigInteger.valueOf(2)));
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine())  != null && !line.isEmpty()) {
            int N = Integer.parseInt(line);
            sb.append(arr[N]).append("\n");
        }

        System.out.print(sb);
    }
}

