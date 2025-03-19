import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int fiveBags = N / 5;

        while (fiveBags >= 0) {
            int remaining = N - (fiveBags * 5);
            if (remaining % 3 == 0) {
                int threeBags = remaining / 3;
                System.out.println(fiveBags + threeBags);
                return;
            }
            fiveBags--;
        }
        System.out.println(-1);
        br.close();
    }
}
