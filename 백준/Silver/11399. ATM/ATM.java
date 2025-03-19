import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //사람의 수
        String time = br.readLine(); //각 사람이 돈을 인출하는데 걸리는 시간
        List<Integer> P = new ArrayList();

        for (String t : time.split(" ")) {
            P.add(Integer.parseInt(t));
        }

        Collections.sort(P);

        int totalTime = 0;
        int currentSum = 0;
        for (int t : P) {
            currentSum += t;
            totalTime += currentSum;
        }

        System.out.println(totalTime);
    }
}