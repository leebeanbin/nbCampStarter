package weekOne.calculatorTwo;

import weekOne.calculatorTwo.exception.CustomException;
import weekOne.calculatorTwo.operator.Operators;


import java.util.ArrayList;
import java.util.List;

public class OperateCalculator{
    private int one;
    private int two;
    private char oper;
    private int res;
    private Character[] opers = {'+', '-', '*', '/'};
    private static List<Integer> basket = new ArrayList<>();;

    public OperateCalculator(int one, int two, char oper) throws CustomException {
        this.one = one;
        this.two = two;
        this.oper = oper;
    }

    public List<Integer> calculateOperations() throws CustomException {
        // 결과값 저장 및 반환
        Operators ops = new Operators(one,two, oper);
        basket = ops.result();
        return basket;
    }
}
