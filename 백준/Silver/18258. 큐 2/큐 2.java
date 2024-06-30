import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static Queue<Integer> queue= new LinkedList<>();
    private static int rear = 0;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt((bf.readLine()));

        String commandLine;
        for (int i = 0; i < N; i++) {
            commandLine = bf.readLine();
            processCommand(commandLine);
        }
        System.out.println(sb);
    }

    public static void processCommand(String commandLine){
        String[] command = commandLine.split(" ");
        switch (command[0]) {
            case "push":
                rear = Integer.parseInt(command[1]);
                queue.add(Integer.parseInt(command[1]));
                break;
            case "pop":
                if(queue.isEmpty()) sb.append(-1).append('\n');
                else sb.append(queue.remove()).append('\n');
                break;
            case "size":
                sb.append(queue.size()).append('\n');
                break;
            case "empty":
                if(queue.isEmpty()) sb.append(1).append('\n');
                else sb.append(0).append('\n');
                break;
            case "front":
                if(queue.isEmpty()) sb.append(-1).append('\n');
                else sb.append(queue.element()).append('\n');
                break;
            case "back":
                if(queue.isEmpty()) sb.append(-1).append('\n');
                else sb.append(rear).append('\n');
                break;
        }
    }
}