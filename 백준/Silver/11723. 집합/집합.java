import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        /*set
        * HashSet
        * 데이터를 정렬하지 않고 저장(데이터 순서가 중요하지 않은 상황에서 가장 효율적)
        * 삽입, 삭제, 검색의 평균 시간 복잡도는 O(1)
        *
        * TreeSet
        * 데이터를 정렬된 상태로 유지(특정 범위 검색이 중요한 경우에 유리)
        * 삽입, 삭제, 검색의 시간 복잡도는 O(logn)
        */

        //add x: 이미 있는 경우에는 연산을 무시
        //remove x: x가 없는 경우에는 연산을 무시
        //check x: x가 있으면 1을, 없으면 0을 출력
        //toggle x: x가 있으면 제거, 없으면 추가
        //all: S를 {1, 2, ..., 20}으로 바꾼다.
        //empty: S를 공집합으로 바꾼다.

        int M = Integer.parseInt(br.readLine());

        int S = 0; // 비트마스크로 집합을 표현
                   // S는 0부터 20까지의 요소에 대해 1이면 포함, 0이면 제외

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            String operation = input[0];
            int x = 0;

            if (input.length == 2) {
                x = Integer.parseInt(input[1]);
            }

            if (operation.equals("add")) {
                if (x >= 1 && x <= 20) {
                    S |= (1 << (x - 1));  // x번째 비트를 1로 설정
                }
            } else if (operation.equals("remove")) {
                if (x >= 1 && x <= 20) {
                    S &= ~(1 << (x - 1)); // x번째 비트를 0으로 설정
                }
            } else if (operation.equals("check")) {
                if (x >= 1 && x <= 20) {
                    if ((S & (1 << (x - 1))) != 0) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                }
            } else if (operation.equals("toggle")) {
                if (x >= 1 && x <= 20) {
                    S ^= (1 << (x - 1)); // x번째 비트를 반전
                }
            } else if (operation.equals("all")) {
                S = (1 << 20) - 1;  // 1부터 20까지 모든 비트를 1로 설정
            } else if (operation.equals("empty")) {
                S = 0;  // 모든 비트를 0으로 설정
            }
        }

        System.out.print(sb.toString());
    }
}
