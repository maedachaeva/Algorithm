import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int count = 1; count <= T; count++) {
            Stack<Character> stack = new Stack<>();

            String ps = br.readLine();
            boolean isValid = true;

            for (int i = 0; i < ps.length(); i++) {
                char c = ps.charAt(i);

                if (c == '(') {
                    stack.push(c);
                }
                else if (c == ')') {
                    if (stack.isEmpty()) {
                        System.out.println("NO");
                        isValid = false;
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
            }

            if (isValid && stack.isEmpty()) {
                System.out.println("YES");
            }
            else if (isValid) {
                System.out.println("NO");
            }
        }
    }
}
