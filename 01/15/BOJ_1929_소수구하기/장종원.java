import java.io.;
import java.util.;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> result = Prime(m);

        for(int i = 0; i < result.size(); i++) {
            if(result.get(i) >= n) {
                System.out.println(result.get(i));
            }
        }
    }

    public static List<Integer> Prime(int m) {
        boolean[] isPrime = new boolean[m + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;
        List<Integer> result = new ArrayList<>();

        for (int i = 2; i <= Math.sqrt(m); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= m; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= m; i++) {
            if (isPrime[i]) {
                result.add(i);
            }
        }

        return result;
    }
}
