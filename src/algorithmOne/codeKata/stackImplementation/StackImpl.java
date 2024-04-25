package algorithmOne.codeKata.stackImplementation;

import java.util.Stack;

public class StackImpl {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");

        stack.pop(); // C out
        stack.pop(); // B out
        System.out.println(stack); // a 만 남은것을 알 수 있다.
    }
}
