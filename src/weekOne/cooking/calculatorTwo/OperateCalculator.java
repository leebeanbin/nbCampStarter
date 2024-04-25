package weekOne.cooking.calculatorTwo;

import weekOne.cooking.calculatorTwo.operator.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OperateCalculator implements Service{

    // 정수값을 받아와서 저장한다.
    private int one;
    private int two;
    private char oper;
    private int Area;
    private Character[] opers = {'+', '-', '*', '/'};
    private static List<Integer> basket;

    private Operator operator;

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public int calculate(int x, int y) {
        return operator.operate(x, y);
    }

    public OperateCalculator(int one, int two, char oper) throws CustomException {
        if(one == 0 && two == 0 ){
            throw new CustomException("This Value are available to calculate.");
        }else if(!Arrays.asList(this.opers).contains(oper)){
            throw new CustomException("This operation is not supported.");
        }else{
            this.one = one;
            this.two = two;
            this.oper = oper;
            basket = new ArrayList<>();
        }
    }

    public int calculateOperations() throws CustomException {
        // 결과값 저장 및 반환
        basket.add(calculate(one, two));
        return calculate(one, two);
    }

    @Override
    public void exited() {
        System.exit(0);
    }

    @Override
    public void remove() {
        System.out.println("Removing " + basket.get(0));
        basket.remove(0);
    }

    @Override
    public void inquiry() {
        System.out.print("Basket Status : ");
        for (Integer i : basket) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }
}
