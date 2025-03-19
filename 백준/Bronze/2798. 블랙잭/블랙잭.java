import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] splitedInput = input.split(" ");
        int N = Integer.parseInt(splitedInput[0]);
        int M = Integer.parseInt(splitedInput[1]);

        String numbers = br.readLine();
        String[] number = numbers.split(" ");

        int maxSum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = Integer.parseInt(number[i]) + Integer.parseInt(number[j]) + Integer.parseInt(number[k]);

                    if (sum <= M && sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
        }
        System.out.println(maxSum);
    }
}
