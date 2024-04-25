package weekOne.calculatorTwo.operator;

public class AddOperator implements Operator{
    private int a;
    private int b;
    public AddOperator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int operate() {
        return a+b;
    }
}
