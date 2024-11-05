import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String hi =
        "Hello\n#@#@#@#@#@\nCodeTree\n@#@#@#@#@#\nStudents!\n\n";

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            sb.append(hi);
        }

        System.out.println(sb);
    }
}