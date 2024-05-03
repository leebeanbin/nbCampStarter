package finalCalculator;

import javax.management.OperationsException;
import javax.naming.OperationNotSupportedException;
import java.util.List;

public class Calculator {
    private List<Double> results;
    private List<Double> circleResults;

    public Calculator(List<Double> results,List<Double> circleResults ) {
        this.results = results;
        this.circleResults = circleResults;
    }

    public double CircleCalculate(int radius){
        return Math.PI*radius*radius;
    }

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

    public List<Double> getResults() {
        return results;
    }

    public void setResults(List<Double> results) {
        this.results = results;
    }


    public List<Double> getCircleResults() {
        return circleResults;
    }

    public void setCircleResults(List<Double> circleResults) {
        this.circleResults = circleResults;
    }

    public void remove(Object remove){
        if(remove.equals("remove")) results.removeFirst();
    }

    public void inquiryProgram(Object inquiry){
        if(inquiry.equals("inquiry")){
            results.forEach(i -> System.out.println(i + " "));
        }
    }

    public void inquiryCircle(Object s) {
        if(s.equals("inquiry")){
            circleResults.forEach(i -> System.out.println(i + " "));
        }
    }

    public void removeCircle(String s) {
        if(s.equals("remove")) circleResults.removeFirst();
    }
}
