import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String[] command = input.split(" ");

            switch (command[0]) {
                case "push":
                    int value = Integer.parseInt(command[1]);
                    queue.add(value);
                    break;
                case "pop":
                    if (!queue.isEmpty()) {
                        bw.write(queue.poll() + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    bw.write((queue.isEmpty() ? "1" : "0") + "\n");
                    break;
                case "front":
                    if (!queue.isEmpty()) {
                        bw.write(queue.peek() + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;
                case "back":
                    if (!queue.isEmpty()) {
                        bw.write(((ArrayDeque<Integer>) queue).peekLast() + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}
