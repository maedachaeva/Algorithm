import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());

        // 리스트를 쓰자

        List<String[]> members = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            members.add(br.readLine().split(" "));
        }

        members.sort((a, b) -> Integer.parseInt(a[0]) - Integer.parseInt(b[0]));

        for (String[] member : members) {
            bw.write(member[0] + " " + member[1] + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}