import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        for (int count = 1; count <= N; count++) {
            String command = br.readLine();
            String[] splitedCommand = command.split(" ");

            switch (splitedCommand[0]) {
                case "push":
                    int number = Integer.parseInt(splitedCommand[1]);
                    stack.push(number);
                    break;

                case "pop":
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                    }
                    else {
                        System.out.println(stack.pop());
                    }
                    break;

                case "size":
                    System.out.println(stack.size());
                    break;

                case "empty":
                    if (stack.isEmpty()) {
                        System.out.println(1);
                    }
                    else {
                        System.out.println(0);
                    }
                    break;

                case "top":
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                    }
                    else {
                        System.out.println(stack.peek());
                    }
                    break;
            }
        }
    }
}