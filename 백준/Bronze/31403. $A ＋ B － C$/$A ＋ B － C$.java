import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();

        int numberSum = Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C);

        String ab = A + B;
        int numberAB = Integer.parseInt(ab);
        int finalResult = numberAB - Integer.parseInt(C);

        System.out.println(numberSum);
        System.out.println(finalResult);
       
    }
}
