package algorithmOne.codeKata.stackImplementation;


public class StackNodeImpl {
    public static void main(String[] args) {
        StackNode<Integer> stack = new StackNode<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.print();

        System.out.println("현재 스택의 top을 출력합니다: " + stack.peek() + "\n");

        System.out.println("pop: "+stack.pop());
        System.out.println("pop: "+stack.pop());

        stack.print();

    }
}
