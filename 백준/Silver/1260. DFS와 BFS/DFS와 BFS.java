import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] splitedInput = br.readLine().split(" ");
        int N = Integer.parseInt(splitedInput[0]); // 정점 수
        int M = Integer.parseInt(splitedInput[1]); // 간선 수
        int V = Integer.parseInt(splitedInput[2]); // 탐색 시작점

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>()); // 각 정점을 위한 빈 리스트 추가
        }

        // 간선 정보 입력받기
        for (int i = 0; i < M; i++) {
            String[] splitedInputM = br.readLine().split(" ");
            int u = Integer.parseInt(splitedInputM[0]);
            int v = Integer.parseInt(splitedInputM[1]);
            graph.get(u).add(v);
            graph.get(v).add(u); // 무방향 그래프이므로 양방향으로 추가
        }

        // 각 정점의 인접 리스트를 오름차순으로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new boolean[N + 1]; // visited 배열 선언 및 초기화
        dfs(V);
        System.out.println();

        visited = new boolean[N + 1]; // 다시 초기화
        bfs(V);
    }

    // DFS (재귀)
    static void dfs(int node) { // node: 현재 탐색 중인 정점
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : graph.get(node)) { // node번 정점에 연결된 모든 정점들을 담고 있는 리스트를 반환
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    // BFS (큐)
    static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited[V] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll(); // 큐에서 첫 번째 요소를 꺼냄
            System.out.print(node + " ");

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}
