package weekOne.calculatorTwo.operator;

import weekOne.calculatorTwo.OperateCalculator;
import weekOne.calculatorTwo.exception.CustomException;

import java.util.ArrayList;
import java.util.List;

public class Operators extends OperateCalculator {

    private int one;
    private int two;
    private char oper;

    private int res;
    private List<Integer> basket = new ArrayList<>();

    public Operators(int one, int two, char oper) throws CustomException {
        super(one, two, oper);
        this.one = one;
        this.two = two;
        this.oper = oper;
    }

    public List<Integer> result(){
        switch (oper){
            case '+':
                res = new AddOperator(this.one, this.two).operate();
                break;
            case '-':
                res = new SubtractOperator(this.one, this.two).operate();
                break;
            case '*':
                res = new MultiplyOperator(this.one, this.two).operate();
                break;
            case '/':
                res = new DivideOperator(this.one, this.two).operate();
                break;
        }
        System.out.print(res);
        return basket;
    }
}
