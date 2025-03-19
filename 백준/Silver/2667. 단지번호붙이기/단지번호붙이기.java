import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] graph;
    static List<Integer> complexSizes = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동 (x축)
    static int[] dy = {0, 0, -1, 1}; // 상하좌우 이동 (y축)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 연결된 컴포넌트 개수 찾기 유형이라 DFS/BFS 사용해야 한다고 함
        // 그래프 + DFS

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        // 그래프 입력 받기
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = input.charAt(j) - '0'; // 문자 '1' → 숫자 1 변환
            }
        }

        // DFS 실행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1) { // 1일 때만
                    int size = dfs(i, j);
                    complexSizes.add(size);
                }
            }
        }

        Collections.sort(complexSizes);
        bw.write(complexSizes.size() + "\n");

        for (int size : complexSizes) {
            bw.write(size + "\n");
        }

        bw.flush();
        bw.close();
    }

    static int dfs(int x, int y) {
        graph[x][y] = 0; // 방문한 곳을 0으로 변경
        int size = 1; // 현재 단지 크기(1부터 시작)

        for (int i = 0; i < 4; i++) { // 상하좌우 이동
            // 이동하려는 좌표 (nx, ny)가 1이면 DFS를 호출하여 계속 탐색
            int nx = x + dx[i]; // 새로 이동할 x 좌표
            int ny = y + dy[i]; // 새로 이동할 y 좌표

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && graph[nx][ny] == 1) {
                // nx >= 0 && nx < N : 배열의 x(행) 좌표가 범위를 벗어나지 않는지
                // ny >= 0 && ny < N → 배열의 y(열) 좌표가 범위를 벗어나지 않는지
                // graph[nx][ny] == 1 → 해당 위치가 방문할 수 있는 곳인지
                size += dfs(nx, ny); // 연결된 곳 탐색
            }
        }
        return size;
    }
}
