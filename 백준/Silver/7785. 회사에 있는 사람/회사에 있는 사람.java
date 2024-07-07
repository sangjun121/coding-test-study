import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        String[][] members = new String[N][2];

        for (int i = 0; i < N; i++) {
            members[i] = br.readLine().split(" ");
        }

        //사전순 정렬. stable하다. (nlogn)
        Arrays.sort(members, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o2[0].compareTo(o1[0]);
            }
        });

        //순회 N
        for (int i = 0; i < N-1; i++) {
            if(members[i][1].equals("enter") && !members[i][0].equals(members[i+1][0])) {
                bw.write(members[i][0] + "\n");
                bw.flush();
            }
        }
        if(members[N-1][1].equals("enter"))
            bw.write(members[N-1][0] + "\n");

        bw.close();
    }
}
