import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); //1. 타워 개수
        StringTokenizer st = new StringTokenizer(br.readLine()); //2. StringTokenizer로 타워높이 입력
        int[] towers = new int[N]; //타워 저장할 배열
        int index = 0;

        while (st.hasMoreTokens()) { //타워 높이 정수 배열로 변환
            towers[index++] = Integer.parseInt(st.nextToken());
        }

        // 1. 지금까지 중 가장 큰 값보다 크면 무조건 0
        // 2. 가장 큰값 나올때 마다 스택에 저장?
        Stack<Integer> stack = new Stack<>();
        int topIndex = -1;

        for (int i = 0; i < N; i++) {
            while(!stack.isEmpty()) {
                topIndex = stack.peek();
                if(towers[topIndex] > towers[i]) {
                    sb.append(topIndex+1).append(" ");
                    stack.push(i);
                    break;
                }
                stack.pop();
            }

            if(stack.isEmpty()) {
                sb.append(0).append(" ");
                stack.push(i);
            }
        }

        System.out.println(sb);
    }

}
