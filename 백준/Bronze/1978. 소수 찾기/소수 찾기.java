import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        String[] splitedInput = input.split(" ");
        
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(splitedInput[i]);
        }

        int count = 0;

        for (int number : numbers) {
    		if (number > 1) {
        		boolean isPrime = true;
        		for (int i = 2; i <= Math.sqrt(number); i++) {
            		if (number % i == 0) {
                		isPrime = false;
                		break;
            		}
        		}
        		if (isPrime) {
            		count++;
        		}
    		}
		}

        System.out.println(count);
    }
}