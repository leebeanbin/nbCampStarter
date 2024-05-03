package finalCalculator;

public class AddOperator implements Operator {

    @Override
    public double operate(int a, int b) {
        return a+b;
    }
}
