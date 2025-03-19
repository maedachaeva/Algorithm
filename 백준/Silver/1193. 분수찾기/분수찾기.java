import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());

        /*
        1. X가 속한 그룹을 찾기
            sum = 1, 3, 6, 10, ... 이므로 n(n+1)/2 ≥ X 를 만족하는 최소 n을 찾기
        2. X가 해당 그룹에서 몇 번째인지 찾기
            index = X - (이전 그룹의 마지막 번호)
        3. 홀수/짝수 그룹에 따라 분수 계산
        */

        int group = 1;

        while (X > group * (group + 1) / 2) {
            group++;
        }

        int index = X - ((group - 1) * group / 2);

        int numerator, denominator; //분자, 분모

        if (group % 2 == 0) { //even(분자증가 분모감소)
            numerator = index;
            denominator = group - index + 1;
        } else { //odd(분자감소 분모증가)
            numerator = group - index + 1;
            denominator = index;
        }

        System.out.println(numerator + "/" + denominator);
    }
}
