import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        Member[] members = new Member[N];

        for(int i = 0; i<N; i++){
            String[] s = br.readLine().split(" ");
            members[i] = new Member(s[1], Integer.parseInt(s[0]));
        }

        Arrays.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o1.age - o2.age;
            }
        });

        for(int i = 0; i<N; i++){
            bw.write(members[i].age+" "+members[i].name);
            bw.newLine();
            bw.flush();
        }
        bw.close();

    }

    static class Member{

        private String name;
        private int age;

        public Member(String name, int age){
            this.name = name;
            this.age = age;
        }
    }
}
