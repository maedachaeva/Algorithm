import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String[] splitedInput = input.split("");

            int sum = 0;
            int score = 0;
            for (String c : splitedInput) {
                if (c.equals("O")) {
                    score++;
                    sum += score;
                }
                else {
                    score = 0;
                }
            }
            System.out.println(sum);
        }
    }
}
