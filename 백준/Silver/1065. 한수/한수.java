import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        int count = 0;
        for (int i = 1; i <= Integer.parseInt(N); i++) {
            if (i >= 1 && i < 100) {
                count++;
            }
            else { //246
                String[] splitedI = String.valueOf(i).split("");
                int num1 = Integer.parseInt(splitedI[0]);
                int num2 = Integer.parseInt(splitedI[1]);
                int num3 = Integer.parseInt(splitedI[2]);

                if (num1 - num2 == num2 - num3) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}