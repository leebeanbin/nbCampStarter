package finalCalculator;

public class SubtractOperator implements Operator {
    @Override
    public double operate(int a, int b) {
        return a-b;
    }
}
