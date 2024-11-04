import java.util.*;
import java.io.*;

public class Main {

    private static HashMap<String, Integer> nameDb;
    private static HashMap<Integer, String> valueDb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        nameDb = new HashMap<>();
        valueDb = new HashMap<>();

        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++) {
            String[] input = br.readLine().split(" ");
            
            switch(input[0]) {
                case "init" :
                init();
                break;

                case "insert" :
                sb.append(insert(input[1], input[2]));
                sb.append("\n");
                break;

                case "delete" :
                sb.append(delete(input[1]));
                sb.append("\n");
                break;

                case "rank" :
                sb.append(rank(input[1]));
                sb.append("\n");
                break;

                case "sum" :
                sb.append(sum(input[1]));
                sb.append("\n");
                break;
            }
        }

        System.out.println(sb);
    }

    static void init() {
        nameDb.clear();
        valueDb.clear();
    }

    static int insert(String name, String value) {
        if(nameDb.containsKey(name)) return 0;

        int val = Integer.parseInt(value);
        if(valueDb.containsKey(val)) return 0;

        nameDb.put(name, val);
        valueDb.put(val, name);

        return 1;
    }

    static int delete(String name) {
        if(!nameDb.containsKey(name)) return 0;

        int val = nameDb.get(name);
        nameDb.remove(name);
        valueDb.remove(val);
        return 1;
    }

    static String rank(String k) {
        int r = Integer.parseInt(k);
        if(r > valueDb.size()) return "None";

        Integer[] values = valueDb.keySet().toArray(new Integer[0]);
        Arrays.sort(values);

        return valueDb.get(values[r-1]);
    }

    static long sum(String k) {
        int r = Integer.parseInt(k);

        Integer[] values = valueDb.keySet().toArray(new Integer[0]);
        Arrays.sort(values);

        int index = 0;
        long total = 0;
        while(values[index] <= r) {
            total += values[index++];
            if(index >= values.length) break;
        }

        return total;
    }
}