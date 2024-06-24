import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        Stack stack = new Stack();
        Input input = new Input();
        int commandCount;
        String[] command;

        commandCount = input.readCommandCounts();
        for (int i = 0; i < commandCount; i++) {
            command = input.readCommand().split(" ");
            switch (command[0]){
                case "push":
                    stack.push(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    sb.append(stack.pop()).append('\n');
                    break;
                case "size":
                    sb.append(stack.size()).append('\n');
                    break;
                case "empty":
                    sb.append(stack.isEmpty()).append('\n');
                    break;
                case "top":
                    sb.append(stack.top()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}

class Input{
    private Scanner sc;

    public Input(){
        sc = new Scanner(System.in);
    }

    public int readCommandCounts(){
        return Integer.parseInt(sc.nextLine());
    }

    public String readCommand(){
        String command = sc.nextLine();
        return command;
    }

}

class Stack{
    private ArrayList<Integer> stack = new ArrayList<Integer>();

    public Stack(){}

    public void push(int x){
        stack.add(x);
    }

    public int pop(){
        if (stack.isEmpty()) return -1;
        return stack.remove(stack.size()-1);
    }

    public int size(){
        return stack.size();
    }

    public int isEmpty(){
        if(stack.isEmpty()) return 1;
        return 0;
    }

    public int top(){
        if(stack.isEmpty()) return -1;
        return stack.get(stack.size()-1);
    }
}