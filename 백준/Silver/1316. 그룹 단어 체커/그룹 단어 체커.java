import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 단어의 개수
        int groupWordCount = 0;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (isGroupWord(word)) {
                groupWordCount++;
            }
        }
        System.out.println(groupWordCount);
    }

    private static boolean isGroupWord(String word) {
        Set<Character> seen = new HashSet<>();
        char previousChar = '\0'; // 이전 문자를 저장하기 위한 변수 초기화

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            if (currentChar != previousChar) {
                if (seen.contains(currentChar)) {
                    return false;
                }
                seen.add(currentChar);
            }
            previousChar = currentChar;
        }
        return true;
    }
}