import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.MIN_VALUE;
        int row = 0, col = 0;

        for (int i = 1; i <= 9; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= 9; j++) {
                int num = Integer.parseInt(input[j - 1]);
                if (num > max) {
                    max = num;
                    row = i;
                    col = j;
                }
            }
        }

        System.out.println(max);
        System.out.println(row + " " + col);
    }
}