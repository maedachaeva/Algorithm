import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String S = scanner.nextLine(); //10,20,30,50,100
        String[] splitedS = S.split(",");

        System.out.println(splitedS.length);
    }
}