import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        TreeSet<Integer> list = new TreeSet<>();

        for(int i=1; i<=Math.sqrt(N); i++) {
            if(N%i == 0) {
                list.add(i);
                list.add(N / i);
            }
        }

        for(int n : list) {
            sb.append(n + " ");
        }

        System.out.println(sb);
    }
}