import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // M개의 수들이 A[N]에 존재하는지 확인
        // 이진탐색으로
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        String[] inputA = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(inputA[i]);
        }

        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        String[] inputB = br.readLine().split(" ");

        // M개의 수 입력 받는 즉시 A에 있는지 검사
        for (int i = 0; i < M; i++) {
            int m = Integer.parseInt(inputB[i]);

            if (binarySearch(A, m)) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }
        bw.flush();
        bw.close();
    }

    /*
    * 이진 탐색 (binarySearch 메서드)
    * 배열 내에서 key 값을 찾기 위해 left, right, mid를 사용합니다.
    * 탐색 범위를 좁혀가며 key의 존재 여부를 확인합니다.
    */
    private static boolean binarySearch(int[] arr, int key) {
        int left = 0; // 첫 인덱스
        int right = arr.length - 1; // 마지막 인덱스

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == key) { // 찾았으면
                return true;
            }
            if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
