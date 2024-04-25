package algorithmOne.codeKata.stackImplementation;

public class StackNode<T>{
    private Node<T> top;

    private boolean isEmpty(){
        return this.top == null;
    }

    public void push(T data){
        Node<T> newNode = new Node<>();
        newNode.data = data;
        newNode.next = this.top;
        this.top = newNode;
    }

    public T pop() {
        if (this.isEmpty()) {
            return null;
        }

        T data = this.top.data;
        this.top = this.top.next;

        return data;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }

        return this.top.data;
    }

    public void print() {
        System.out.println("\n현재 스택의 내용을 top부터 출력합니다.");

        if (this.isEmpty()) {
            System.out.println("스택이 비어 있습니다.");
        } else {
            Node<T> currentNode;
            currentNode = this.top;

            while (currentNode != null) {
                System.out.print("[ " + currentNode.data + " ]  ");
                currentNode = currentNode.next;
            }
        }
        System.out.println("\n");
    }
}
