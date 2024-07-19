import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] init = br.readLine().split(" ");
        int N = Integer.parseInt(init[0]);
        int C = Integer.parseInt(init[1]);

        String[] numbers = br.readLine().split(" ");

        Message[] messages = new Message[N];
        for (int i = 0; i < N; i++) {
            messages[i] = new Message(i, Integer.parseInt(numbers[i]));
        }

        Arrays.sort(messages, (o1, o2) -> o1.num - o2.num); //정렬, stable하게 정렬되므로 같은 숫자에 대해서는 idx번호 작은 순으로 정렬될 것

        Frequency[] frequencys = new Frequency[N];

        int frequencyIdx = 0;
        frequencys[0] = new Frequency(messages[0].num, 1, messages[0].idx);
        for (int i = 1; i < N; i++) {
            if (messages[i - 1].num == messages[i].num)
                frequencys[frequencyIdx].frequency++;
            else {
                frequencys[++frequencyIdx] = new Frequency(messages[i].num, 1, messages[i].idx);
            }
        }

        Arrays.sort(frequencys, 0, frequencyIdx + 1, new Comparator<Frequency>() { //범위지정 (시작 인덱스, 원하는 마지막 인덱스+1)
            @Override
            public int compare(Frequency o1, Frequency o2) {
                if (o1.frequency == o2.frequency)
                    return o1.firstIdx - o2.firstIdx;
                return o2.frequency - o1.frequency;
            }
        });

        for (int i = 0; i <= frequencyIdx; i++) {
            for (int j = 0; j < frequencys[i].frequency; j++) {
                bw.write(frequencys[i].num + " ");
            }
        }
        bw.close();
    }

    static class Message {
        int idx;
        int num;

        public Message(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }

    static class Frequency {
        int num;
        int frequency;
        int firstIdx;

        public Frequency(int num, int frequency, int firstIdx) {
            this.num = num;
            this.frequency = frequency;
            this.firstIdx = firstIdx;
        }
    }
}
