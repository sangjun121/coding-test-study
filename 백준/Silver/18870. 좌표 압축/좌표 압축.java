import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        String[] dotsString = br.readLine().split(" ");
        int[] dots = new int[N];
        Set<Integer> dotsSet = new TreeSet<Integer>();

        for (int i = 0; i < N; i++) { //nlogn
            dots[i] = Integer.parseInt(dotsString[i]);
            dotsSet.add(dots[i]);
        }

        Map<Integer, Integer> dotsMap = new HashMap<>();
        int idx = 0;

        for (int x : dotsSet) {
            dotsMap.put(x, idx);
            idx++;
        }

        for (int i = 0; i < N; i++) {
            bw.write(dotsMap.get(dots[i]) + " ");
        }

        bw.close();
    }
}
