package finalCalculator;

import java.util.List;

public class ArithmeticCalculator extends Calculator{
    public ArithmeticCalculator(List<Double> result) {
        super(result);
    }

    @Override
    public double calculate(int a, int b, char operator) {
        double result = 0;

        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if(b != 0){
                    double v = (double) a / b;
                }else{
                    throw new ArithmeticException();
                }
                break;
            case '%':
                result = a % b;
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
