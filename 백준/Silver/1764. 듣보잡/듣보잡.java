import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //듣도 못한 사람 && 보도 못한 사람 구하기
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        HashSet<String> unheard = new HashSet<>();
        for (int i = 0; i < N; i++) {
            unheard.add(br.readLine());
        }

        ArrayList<String> dbj = new ArrayList<>();
        for (int j = 0; j < N; j++) {
            String unseen = br.readLine();
            if (unheard.contains(unseen)) {
                dbj.add(unseen);
            }
        }

        Collections.sort(dbj);

        System.out.println(dbj.size());
        for (String name : dbj) {
            System.out.println(name);
        }
    }
}
