import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int N;
    static int M;
    static int[][] square;
    static int[] dx = {-1, 1, 0, 0}; // 상하
    static int[] dy = {0, 0, -1, 1}; // 좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        square = new int[N][M];
        visited = new boolean[N][M];

        // 미로 입력
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                square[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        square[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            // 도착하면 거리 반환
            if (currentX == N - 1 && currentY == M - 1) {
                return square[currentX][currentY];
            }

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                // 범위 체크 및 방문 여부 확인
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if (!visited[nextX][nextY] && square[nextX][nextY] == 1) {
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        square[nextX][nextY] = square[currentX][currentY] + 1; // 한 칸 갈 때마다 거리 +1
                    }
                }
            }
        }
        return -1; // 도달할 수 없는 경우
    }
}