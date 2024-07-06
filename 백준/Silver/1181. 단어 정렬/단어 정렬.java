import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        String[] inputs = new String[N];

        for(int i = 0; i<N; i++){
            inputs[i] = br.readLine();
        }

        Arrays.sort(inputs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                else
                    return o1.length() - o2.length();
            }
        });

        for(int i = 0; i<N; i++){
            if(i == 0 || !inputs[i].equals(inputs[i-1])) bw.write(inputs[i] + "\n");
        }
        bw.close();
    }
}
