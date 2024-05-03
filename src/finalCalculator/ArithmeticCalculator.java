package finalCalculator;

import java.util.List;

public class ArithmeticCalculator extends Calculator{
    private final AddOperator addOperator;
    private final SubtractOperator subtractOperator;
    private final MultiplyOperator multiplyOperator;
    private final DivideOperator divideOperator ;

    public ArithmeticCalculator(List<Double> result , AddOperator addOperator,
                                SubtractOperator subtractOperator, MultiplyOperator multiplyOperator,
                                DivideOperator divideOperator) {
        super(result);
        this.addOperator = addOperator;
        this.subtractOperator = subtractOperator;
        this.multiplyOperator = multiplyOperator;
        this.divideOperator = divideOperator;
    }

    @Override
    public double calculate(int a, int b, char operator) {
        double result = 0;

        switch (operator) {
            case '+':
                result = addOperator.operate(a,b);
                break;
            case '-':
                result = subtractOperator.operate(a,b);
                break;
            case '*':
                result = multiplyOperator.operate(a,b);
                break;
            case '/':
                if(b != 0){
                    result = divideOperator.operate(a,b);
                }else{
                    throw new ArithmeticException();
                }
                break;
            default:
                throw new UnsupportedOperationException();
        };

        return result;
    }

    @Override
    double calculate(int radius) {
        return 0;
    }

    @Override
    public void remove(Object remove){
        if(remove.equals("remove")) super.getResults().removeFirst();
    }

    @Override
    public void inquiry(Object query){
        if(query.equals("inquiry")){
            super.getResults().forEach(i -> System.out.println(i + " "));
        }
    }
}
