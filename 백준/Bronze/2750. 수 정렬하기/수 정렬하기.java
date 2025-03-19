import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            int number = scanner.nextInt();
            numbers[i] = number;
        }

        Arrays.sort(numbers);

        for (int m : numbers) {
            System.out.println(m);
        }
    }
}
