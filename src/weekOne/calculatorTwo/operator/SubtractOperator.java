package weekOne.calculatorTwo.operator;

public class SubtractOperator implements Operator{
    private int a;
    private int b;
    public SubtractOperator(int a, int b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public int operate() {
        return a-b;
    }
}
