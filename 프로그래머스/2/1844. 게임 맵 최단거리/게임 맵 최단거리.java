import java.util.*;

// 최단거리 - bfs
class Solution {
    public int solution(int[][] maps) {
        // 그래프 선언(row, col)
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        
        int n = maps.length;
        int m = maps[0].length;
        
        // 큐랑 visited 선언
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        // 시작점 예약 (1, 1) -> (0, 0)으로 + distance도 같이
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], dist = cur[2]; 
            
            // if 도착지라면 return distance
            if (r == n-1 && c == m-1) return dist;
            
            // 다음 노드로 이동
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                // 범위 내인지, 1인지, 방문 안 했는지 체크 
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && maps[nr][nc] == 1) {
                    if (!visited[nr][nc]) {
                        visited[nr][nc] = true;
                        // 다음 노드 예약
                        queue.offer(new int[]{nr,nc,dist+1});
                    }
                }
            }
        }
        return -1;
    }
}