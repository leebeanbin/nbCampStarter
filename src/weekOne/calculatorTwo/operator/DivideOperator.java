package weekOne.calculatorTwo.operator;

public class DivideOperator implements Operator{
    private int a;
    private int b;
    public DivideOperator(int a, int b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public int operate() {
        return a/b;
    }
}
