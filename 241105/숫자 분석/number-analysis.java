import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] num = br.readLine().toCharArray();

        String answer = "";
        int total = 0;
        for(char n : num) {
            answer = n + answer;
            total += n - '0';
        }

        answer += " " + total;

        System.out.println(answer);
    }
}