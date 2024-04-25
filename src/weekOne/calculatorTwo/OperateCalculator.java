package weekOne.calculatorTwo;

import weekOne.calculatorTwo.operator.*;

import java.util.ArrayList;
import java.util.List;

public class OperateCalculator{
    private int a;
    private int b;
    private char oper;
    private Operator operator;
    private List<Double> data = new ArrayList<>();

    public OperateCalculator(int a, int b, char oper) {
        this.a = a;
        this.b = b;
        this.oper = oper;
    }

    public List<Double> calculate(char oper) {
        switch (oper) {
            case '+':
                operator = new AddOperator();
                break;
            case '-':
                operator = new SubtractOperator();
                break;
            case '*':
                operator = new MultiplyOperator();
                break;
            case '/':
                operator = new DivideOperator();
                break;
        }
        data.add(operator.operate(a, b));
        return data;
    }
}
