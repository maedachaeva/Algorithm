class Solution {
    int[] dRow = {-1, 1, 0, 0, -1, -1, 1, 1};
    int[] dCol = {0, 0, -1, 1, -1, 1, 1, -1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // 시작점 끝점이 0인 경우에만 탐색
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        boolean[][] visited = new boolean[n][n];
        
        // bfs - 메서드 분리 안 해줘봄
        Queue<int[]> queue = new LinkedList<>();
        
        visited[0][0] = true;
        queue.offer(new int[]{0, 0, 1}); // depth 여기 넣어줌

        while (!queue.isEmpty()) {
            int[] cur = queue.poll(); // 현재 위치랑 depth 들어있음
            int row = cur[0];
            int col = cur[1];
            int depth = cur[2];

            // 마지막 노드 도착하면 종료
            if (row == n-1 && col == n-1) return depth;

            for (int i = 0; i < 8; i++) {
                int nextRow = row + dRow[i];
                int nextCol = col + dCol[i];

								// isValid()로 분리해도 되고 continue 해도 되고
                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && !visited[nextRow][nextCol] && grid[nextRow][nextCol] == 0) {
                    visited[nextRow][nextCol] = true;
                    queue.offer(new int[] {nextRow, nextCol, depth + 1});
                }
            }
        }
        
        return -1;
    }
}