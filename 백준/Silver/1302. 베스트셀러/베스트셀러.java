import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        Map<String,Integer> sales = new HashMap<String,Integer>();

        for (int i = 0; i < N; i++) {
            String title = br.readLine();
            sales.put(title,sales.getOrDefault(title,0)+1);
        }

        String maxTitle="";
        int maxCount = 0;

        for(Map.Entry<String,Integer> entry : sales.entrySet()) {
            String titleName = entry.getKey();
            int count = entry.getValue();

            if(count > maxCount || (count == maxCount && titleName.compareTo(maxTitle)<0)){
                maxTitle = titleName;
                maxCount = count;
            }
        }

        bw.write(maxTitle);
        bw.close();
    }
}
