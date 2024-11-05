import java.util.*;
import java.io.*;

public class Main {

    private static HashMap<String, Integer> nameDb;
    private static HashMap<Integer, String> valueDb;

    private static boolean isSorted;
    private static Integer[] sortedValue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        nameDb = new HashMap<>();
        valueDb = new HashMap<>();
        isSorted = false;

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
        isSorted = false;
    }

    static int insert(String name, String value) {
        if(nameDb.containsKey(name)) return 0;

        int val = Integer.parseInt(value);
        if(valueDb.containsKey(val)) return 0;

        nameDb.put(name, val);
        valueDb.put(val, name);
        
        isSorted = false;

        return 1;
    }

    static int delete(String name) {
        if(!nameDb.containsKey(name)) return 0;

        int val = nameDb.get(name);
        nameDb.remove(name);
        valueDb.remove(val);

        isSorted = false;

        return val;
    }

    static String rank(String k) {
        int r = Integer.parseInt(k);
        if(r > valueDb.size()) return "None";

        if(!isSorted) {
            sortedValue = valueDb.keySet().toArray(new Integer[0]);
            Arrays.sort(sortedValue);

            isSorted = true;
        }

        return valueDb.get(sortedValue[r-1]);
    }

    static long sum(String k) {
        int r = Integer.parseInt(k);

        if(!isSorted) {
            sortedValue = valueDb.keySet().toArray(new Integer[0]);
            Arrays.sort(sortedValue);

            isSorted = true;
        }

        long total = getSum(0, sortedValue.length, r);

        return total;
    }

    static long getSum(int start, int end, int k) {
        if(start >= end) return 0;
        else if(sortedValue[start] > k) return 0;
        else if(sortedValue[end - 1] <= k) {
            return getTotalSum(start, end);
        } else {
            int mid = (start + end + 1) / 2;
            if(sortedValue[mid] > k) {
                return getSum(start, mid, k);
            }
            return getSum(start, mid, k) + getSum(mid, end, k);
        }
    }

    static long getTotalSum(int start, int end) {
        if(start >= end) return 0;
        if(start == end - 1) return sortedValue[start];
        
        int mid = (start + end) / 2;
        return getTotalSum(start, mid) + getTotalSum(mid, end);
    }
}