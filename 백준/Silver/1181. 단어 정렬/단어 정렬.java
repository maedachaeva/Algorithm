import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //단어 개수
        List<String> words = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words.add(word);
        }

        Set<String> uniqueWords = new HashSet<>(words);
        words = new ArrayList<>(uniqueWords);

        words.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));

        for (int n = 0; n < words.size(); n++) {
            bw.write(words.get(n) + "\n");
        }
        bw.flush();
        bw.close();
    }
}