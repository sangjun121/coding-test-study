import java.io.*;
import java.util.Arrays;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int count = 0;

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);

        String[] arr = new String[N];

        for(int i=0; i < N; i++){
            arr[i] = br.readLine();
        }
        Arrays.sort(arr);

        for(int i=0; i<M; i++){
            String key = br.readLine();
            if(Arrays.binarySearch(arr, key) >= 0) {
                count++;
            }
        }

        bw.write(count+"");
        bw.close();
    }
}
