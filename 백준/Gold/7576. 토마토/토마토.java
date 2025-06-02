import java.io.*;
import java.util.*;

public class Main {
    static int[][] box;
    static int n, m;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        m = Integer.parseInt(size[0]); //가로
        n = Integer.parseInt(size[1]); //세로

        box = new int[n][m];
        Queue<Point> queue = new ArrayDeque<>();
        
        // 다 넣음
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(line[j]);
                if (box[i][j] == 1) {
                    queue.add(new Point(i, j));
                }
            }
        }
        
        // 다 뺌
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && box[nx][ny] == 0) {
                    box[nx][ny] = box[p.x][p.y] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, box[i][j]);
            }
        }

        System.out.println(result - 1);
    }    
}
