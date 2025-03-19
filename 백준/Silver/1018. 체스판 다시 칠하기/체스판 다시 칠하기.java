import java.io.*;

public class Main {
    // 체스판 8x8로 자를 곳 찾기
    // 색 다시 칠하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        char[][] chessBoard = new char[N][M];
        for (int line = 0; line < N; line++) {
            String row = br.readLine();
            for (int block = 0; block < M; block++) {
                chessBoard[line][block] = row.charAt(block);
            }
        }

        // i와 j 선택 범위
        // 0 ≤ i ≤ N-8
        // 0 ≤ j ≤ M-8

        // 각각의 선택 범위가 W로 시작할 때, B로 시작할 때를 비교하며 새로 칠해야 할 칸 수를 계산
        // 어느 곳의 타일을 새로 칠할 지는 알 필요가 없음

        int minPaint = Integer.MAX_VALUE; // 최대한 큰 값으로 초기화
                                          // 탐색하면서 더 작은 값을 찾으면 갱신
                                          // 최종적으로 가장 작은 값이 답이 됨

        for (int i = 0; i <= N - 8; i++) { // 행
            for (int j = 0; j <= M - 8; j++) { // 열
                int wRePaint = 0; // W로 시작할 때
                int bRePaint = 0; // B로 시작할 때

                // 재색칠 탐색
                for (int row = 0; row < 8; row++) {
                    for (int col = 0; col < 8; col++) {
                        char current = chessBoard[i+row][j+col];

                        // 짝수 위치는 시작 보드랑 같은 색이어야 함
                        if ((row + col) % 2 == 0) {
                            // W 패턴일 때 짝수 자리가 W가 아니면 W로 재색칠
                            if (current != 'W') wRePaint++;
                            // B 패턴일 때 짝수 자리가 B가 아니면 B로 재색칠
                            if (current != 'B') bRePaint++;
                        }
                        else {
                            // 홀수 자리가 B이 아니면 재색칠
                            if (current != 'B') wRePaint++;
                            // 홀수 자리가 W이 아니면 재색칠
                            if (current != 'W') bRePaint++;
                        }
                    }
                }
                // wRePaint랑 bRePaint 중 더 작은 거
                int currentMin = Math.min(wRePaint, bRePaint);
                // 체스판 어떻게 잘랐을 때 가장 작은가
                minPaint = Math.min(minPaint, currentMin);

            }
        }
        System.out.println(minPaint);
    }
}