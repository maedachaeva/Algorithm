import java.io.*;

public class Main {
    static int M, N, T, K;
    static int[][] graph;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String[] input = br.readLine().split(" ");
            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);
            K = Integer.parseInt(input[2]);

            graph = new int[N][M];
            for (int i = 0; i < K; i++) {
                String[] cabbage = br.readLine().split(" ");
                int X = Integer.parseInt(cabbage[0]); //열
                int Y = Integer.parseInt(cabbage[1]); //행

                graph[Y][X] = 1;
            }

            int count = 0;
            for (int a = 0; a < N; a++) {
                for (int b = 0; b < M; b++) {
                    if (graph[a][b] == 1) {
                        dfs(a, b);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int row, int col) {
        graph[row][col] = 0;

        for (int j = 0; j < 4; j++) {
            int newRow = row + dRow[j];
            int newCol = col + dCol[j];

            if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < M && graph[newRow][newCol] == 1) {
                dfs(newRow, newCol);
            }
        }
    }
}
