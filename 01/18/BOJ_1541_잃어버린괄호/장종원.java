import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String[] numbersList = S.split("-"); // -로 문단을 나눠서 처음으로 -나온 뒤에 숫자들은 모두 뺌
        int result = 0;

        for(int i= 0; i < numbersList.length; i++) {    // 그 후 +로 문단나눠 모두 숫자만 생성
            if(numbersList[i].contains("+")) {
                String[] numberList = numbersList[i].split("\\+"); // '+'를 문자로 사용하려면 이스케이프 처리해야함
                if (i == 0) {
                    for (int j = 0; j < numberList.length; j++) {
                        result += Integer.parseInt(numberList[j]);
                    }
                } else {
                    for (int j = 0; j < numberList.length; j++) {
                        result -= Integer.parseInt(numberList[j]);
                    }
                }
            }
            else {
                if (i == 0) result += Integer.parseInt(numbersList[i]);
                else result -= Integer.parseInt(numbersList[i]);
            }
        }

        System.out.println(result);
    }
}
