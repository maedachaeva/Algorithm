import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int M = Integer.parseInt(br.readLine()); // 간선 수

        // 그래프 초기화 해줘야 함(정점마다의 리스트를 추가)
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력 받기
        for (int i = 1; i <= M; i++) {
            String[] network = br.readLine().split(" ");
            int u = Integer.parseInt(network[0]);
            int v = Integer.parseInt(network[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        /*
         * 1 - [2, 5]
         * 2 - [1, 3, 5]
         * 5 - [1, 2, 6]
         * 3 - [2]
         * 6 - [5]
         * 4 - [7]
         * 7 - [4]
         */

        // DFS로
        visited = new boolean[N + 1];
        dfs(1);
        System.out.println(count);
    }

    // 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력
    // 1번 빼고 세면 됨
    static int count = 0;
    static void dfs(int node) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                count++;
                dfs(neighbor);
            }
        }
    }
}
