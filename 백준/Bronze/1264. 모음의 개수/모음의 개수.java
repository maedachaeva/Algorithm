import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals("#")) break;

            int count = 0;
            for (char c : input.toCharArray()) {
                if ("aeiouAEIOU".indexOf(c) != -1) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
