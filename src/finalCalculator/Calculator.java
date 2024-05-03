package finalCalculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Double> results;

    public Calculator(List<Double> results) {
        this.results = results;
    }

    public double calculate(int a, int b, char operator){
        double result = switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> (double) a / b;
            case '%' -> a % b;
            default -> 0;
        };

        return result;
    }

    public List<Double> getResults() {
        return results;
    }

    public void setResults(List<Double> results) {
        this.results = results;
    }

    public void remove(Object remove){
        if(remove.equals("remove")) results.removeFirst();
    }

    public void inquiryProgram(Object inquiry){
        if(inquiry.equals("inquiry")){
            results.forEach(i -> System.out.println(i + " "));
        }
    }
}
