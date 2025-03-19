import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        String croatianRegex = "c=|c-|dz=|d-|lj|nj|s=|z=";

        word = word.replaceAll(croatianRegex, "X");
        System.out.println(word.length());
    }
}