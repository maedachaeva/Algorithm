import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] scores = new int[num];
        for (int i = 0; i < num; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[num];
        if (num >= 1) dp[0] = scores[0];
        if (num >= 2) dp[1] = scores[0] + scores[1];
        if (num >= 3) dp[2] = Math.max(scores[0] + scores[2], scores[1] + scores[2]);

        for (int i = 3; i < num; i++) {
            dp[i] = Math.max(
                dp[i - 2] + scores[i],                        
                dp[i - 3] + scores[i - 1] + scores[i]      
            );
        }

        System.out.println(dp[num - 1]);
    }
}
