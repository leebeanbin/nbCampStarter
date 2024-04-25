package weekOne.calculatorTwo.operator;

public class MultiplyOperator implements Operator{
    private int a;
    private int b;
    public MultiplyOperator(int a, int b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public int operate() {
        return a*b;
    }
}
