import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();   // N, K
        String[] splitedInput = input.split(" ");
        int N = Integer.parseInt(splitedInput[0]);  // 동전 종류
        int K = Integer.parseInt(splitedInput[1]);  // 만들 돈

        int[] A = new int[N];
        int coinCount = 0;

        for (int i = 0; i < N; i++) {
            String value = br.readLine();
            A[i] = Integer.parseInt(value);
        }

        while (K > 0) {
            for (int i = N - 1; i >= 0; i--) {
                if (K >= A[i]) {
                    coinCount += K / A[i];
                    K %= A[i];
                }
            }
        }

        System.out.println(coinCount);

        // K원을 만드는데 필요한 최소 동전 수 coin 출력

        // ~~1. 그 N개의 줄에 입력 받는 금액을 배열에
        // ~~2. 배열 마지막부터 for --
            // ~~3. K >= 인덱스 비교
            // ~~4. K(4000) >= 인덱스(1000) 만나면
            // ~~K / 인덱스 = 4 >> coin
                // K % 인덱스(200) > 다음 인덱스부터
                    // K % 인덱스(200) > 인덱스(100) 만나면
                        // K % 인덱스(200) / 인덱스(100) = 2 >> coin
                        // 나머지가 0이 됐으므로 종료
    }
}