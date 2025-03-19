import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int[] count = new int[8001];

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            sum += number;
            numbers[i] = number;

            count[number + 4000]++;

            if (number > max) max = number;
            if (number < min) min = number;
        }

        // 2. N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
        Arrays.sort(numbers);
        int mid = numbers[N / 2];

        // 3. N개의 수들 중 가장 많이 나타나는 값 - 카운팅 정렬
        int maxFrequency = 0;
        List<Integer> modes = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxFrequency) {
                maxFrequency = count[i];
                modes.clear();
                modes.add(i - 4000);
            } else if (count[i] == maxFrequency) {
                modes.add(i - 4000);
            }
        }
        Collections.sort(modes);

        double average = (double) sum / N;
        System.out.println(Math.round(average)); // 1. 산술평균 - 예제 3 다름
        // (0 + 0 + (-1)) / 3 = -0.333333... 이고
        // 이를 첫째 자리에서 반올림하면 0이다. -0으로 출력하면 안된다.

        System.out.println(mid); // 2. 중앙값

        if (modes.size() > 1) { // 3. 최빈값
            System.out.println(modes.get(1));
        } else {
            System.out.println(modes.get(0));
        }

        System.out.println(max - min); // 4. 범위
    }
}
