import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static StringBuffer sb = new StringBuffer();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = Integer.parseInt(scanner.nextLine());
        String inputString;
        boolean isVPS;

        for(int i = 0; i < T; i++){
            inputString = scanner.nextLine();
            isVPS = vaildateVPS(inputString);
            if(isVPS) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }
        System.out.println(sb);
    }

    public static boolean vaildateVPS(String inputString){
        Stack<String> stack = new Stack<>();
        for (String s : inputString.split("")) {
            if(!s.equals("(") && !s.equals(")"))
                return false;
            else if (s.equals("(")){
                stack.push(s);
            }
            else if(s.equals(")")){
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }

        if (stack.isEmpty()) return true;
        return false;
    }
}