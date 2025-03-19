import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] size = br.readLine().split(" ");
        int N = Integer.parseInt(size[0]);
        int M = Integer.parseInt(size[1]);

        int[][] result = new int[N][M];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                String[] input = br.readLine().split(" ");
                for (int k = 0; k < M; k++) {
                    result[j][k] += Integer.parseInt(input[k]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
