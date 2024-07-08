import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        String[] dotsString = br.readLine().split(" ");
        Integer[] dots = new Integer[N];
        Map<String, Integer> dotsMap = new HashMap<>();

        for (int i = 0; i < N; i++) { //nlog(n)
            dotsMap.put(dotsString[i], 0);
            dots[i] = Integer.parseInt(dotsString[i]);
        }

        Set<Integer> dotsSet = new HashSet<Integer>(Arrays.asList(dots)); //중복제거
        dots = dotsSet.toArray(new Integer[dotsSet.size()]);
        Arrays.sort(dots); //정렬 nlogn

        for(int i = 0; i < dots.length; i++) { //nlogn
            dotsMap.put(dots[i].toString(), i);
        }

        for(int i = 0; i < N; i++) { //출력
            bw.write(dotsMap.get(dotsString[i]).toString()+" ");
        }
        bw.close();
    }
}
