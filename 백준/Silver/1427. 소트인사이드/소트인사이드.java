import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열을 내림차순으로 정렬

        String N = br.readLine();
        String[] splitedN = N.split("");

        Integer[] arr = new Integer[splitedN.length];
        for (int n = 0; n < splitedN.length; n++) {
            arr[n] = Integer.parseInt(splitedN[n]);
        }

        Arrays.sort(arr, (a, b) -> b - a);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}