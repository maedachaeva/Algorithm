import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지
        //합을 나타낼 때는 수를 1개 이상 사용

        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[11]; // dp 배열 초기화 (1 ≤ n ≤ 10)

        // 초기 값 설정
        dp[1] = 1; // 1 만드는 방법: 1
        dp[2] = 2; // 2 만드는 방법: (1+1), (2)
        dp[3] = 4; // 3 만드는 방법: (1+1+1), (1+2), (2+1), (3)

        // 모든 경우의 수 계산
        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}