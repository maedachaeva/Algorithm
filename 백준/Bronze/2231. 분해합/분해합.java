import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        for (int i = 1; i < N; i++) {
            int sum = i; //198 + 1 + 9 + 8의 198
            int num = i;

            while (num > 0) {
                sum += num % 10; //198에다가 1 + 9 + 8
                num /= 10;
            }

            if (sum == N) {
                System.out.println(i);
                return; //종료
            }
        }
        System.out.println(0);
    }
}
