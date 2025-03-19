import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> generator = new HashSet<>();

        for (int n = 1; n <= 10000; n++) {
            d(n);
            generator.add(d(n));
        }

        for (int i = 1; i <= 10000; i++) {
            if (!generator.contains(i)) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static int d(int n) {
        int n1, n2, n3, n4 = 0;
        if (n < 10) {
            n = n + n;
        }
        else if (10 <= n && n < 100 ){  //10~99
            n1 = n / 10;
            n2 = n % 10;
            n = n + n1 + n2;
        }
        else if (100 <= n && n < 1000) { //823
            n1 = n / 100;
            n2 = n % 100 / 10;
            n3 = n % 100 % 10;
            n = n + n1 + n2 + n3;
        }
        else { // 1234
            n1 = n / 1000;
            n2 = n % 1000 / 100;
            n3 = n % 1000 % 100 / 10;
            n4 = n % 1000 % 100 % 10;
            n = n + n1 + n2 + n3 + n4;
        }
        return n;
    }
}