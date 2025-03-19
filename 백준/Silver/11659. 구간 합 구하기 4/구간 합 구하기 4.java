import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String[] splitedInput = input.split(" ");

        int N = Integer.parseInt(splitedInput[0]);
        int M = Integer.parseInt(splitedInput[1]);

        int[] numbers = new int[N + 1]; // 1-based index를 위해 크기 N+1
        String number = br.readLine();
        String[] numbersInput = number.split(" ");

        // 누적 합 계산
        int[] prefixSum = new int[N + 1];
        for (int o = 1; o <= N; o++) {
            numbers[o] = Integer.parseInt(numbersInput[o - 1]);
            prefixSum[o] = prefixSum[o - 1] + numbers[o];
        }

        // 구간 합 계산
        for (int k = 0; k < M; k++) {
            String section = br.readLine();
            String[] sections = section.split(" ");
            int i = Integer.parseInt(sections[0]);
            int j = Integer.parseInt(sections[1]);

            // 구간 합 = prefixSum[j] - prefixSum[i-1]
            int sum = prefixSum[j] - prefixSum[i - 1];
            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
    }
}
