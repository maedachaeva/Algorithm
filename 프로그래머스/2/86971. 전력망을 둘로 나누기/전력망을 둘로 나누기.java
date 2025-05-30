import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int min_diff = Integer.MAX_VALUE;
        List<Integer>[] graph = new ArrayList[n + 1];
                
        // 그래프 순회하면서 빈 리스트 생성
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
                
        // 인접리스트로 변환
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            graph[v1].add(v2);
            graph[v2].add(v1);            
        }
        
        // 완탐(다 잘라봄)
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            graph[v1].remove(Integer.valueOf(v2));          
            graph[v2].remove(Integer.valueOf(v1));      
         
            boolean[] visited = new boolean[n + 1];
            
            // dfs || bfs 네트워크 개수 셈
            int num = dfs(1, graph, visited);
                
            // |n - nums - nums|
            int network1 = n - num;
            int network2 = num;
                
            // 송전탑의 개수 차이 min_diff에 업뎃 (젤 작은 차이)
            min_diff = Math.min(min_diff, Math.abs(network1 - network2));
            
            // 다시 이어붙이기
            graph[v1].add(v2);
            graph[v2].add(v1);    
        }
        
        return min_diff;
    }
    
    
    // 루트 노드랑 연결되어 있는 노드의 개수
    private int dfs(int root, List<Integer>[] graph, boolean[] visited) {
        visited[root] = true;
        int count = 1; // 자기 자신
        
        // 방문 안 한 다음 노드 
        for (int next : graph[root]) {
            if (!visited[next]) {
                count += dfs(next, graph, visited);
            }
        }
        
        return count;
    }
}