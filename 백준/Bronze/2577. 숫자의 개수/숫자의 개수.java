import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int result = A * B * C; //17037300

        int[] counting = new int[10];

        while (result > 0) {
            counting[result % 10]++;
            result /= 10; //뒤에서부터하나씩줄어든값
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(counting[i]);
        }
    }
}
