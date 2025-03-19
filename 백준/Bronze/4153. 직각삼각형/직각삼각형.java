import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] input = br.readLine().split(" ");
            int first = Integer.parseInt(input[0]);
            int second = Integer.parseInt(input[1]);
            int third = Integer.parseInt(input[2]);

            if (first == 0 && second == 0 && third == 0) break;

            if (first*first + second*second == third*third) {
                System.out.println("right");
            } else if (second*second + third*third == first*first) {
                System.out.println("right");
            } else if (first*first + third*third == second*second) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
