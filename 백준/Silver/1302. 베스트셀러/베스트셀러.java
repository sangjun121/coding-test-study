import java.io.*;
import java.util.Arrays;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        String[] sales = new String[N];

        for (int i = 0; i < N; i++) {
            sales[i] = br.readLine();
        }

        //1. 구매도서 정렬
        Arrays.sort(sales);

        //2. 최대 구매 수량 저장
        int count = 1;
        int maxCount = 1;
        String maxBook = sales[0];

        for (int i = 1; i < N; i++) {
            if (sales[i].equals(sales[i - 1])) {
                count++;
            } else {
                if (maxCount == count && maxBook.compareTo(sales[i - 1]) > 0) {
                    maxBook = sales[i - 1];
                } else if (maxCount < count) {
                    maxCount = count;
                    maxBook = sales[i - 1];
                }
                count = 1;
            }
        }

        //마지막 원소처리
        if (maxCount == count && maxBook.compareTo(sales[N - 1]) > 0) {
            maxBook = sales[N - 1];
        } else if (maxCount < count) {
            maxCount = count;
            maxBook = sales[N - 1];
        }

        bw.write(maxBook);
        bw.close();
    }
}
