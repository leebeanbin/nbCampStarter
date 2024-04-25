package weekOne.calculatorTwo;

import weekOne.calculatorTwo.exception.CustomException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegratedService implements Service{
    int one;
    int two;
    char oper;
    private Character[] opers = {'+', '-', '*', '/'};
    private static List<Integer> basket;

    private OperateCalculator calculator = new OperateCalculator(one, two, oper);
    private CircleCalculator circleCalculator = new CircleCalculator(one);

    public static void setBasket(List<Integer> basket) {
        IntegratedService.basket = basket;
    }

    // 원을 출력을 할때, 사용할 생성자
    public IntegratedService(int one) throws CustomException {
        this.one = one;
        this.circleCalculator = new CircleCalculator(this.one);
    }

    public IntegratedService(int one,int two, char oper) throws CustomException {
        this.one = one;
        this.two = two;
        this.oper = oper;
        this.calculator = new OperateCalculator(this.one, this.two, this.oper);
    }


    public void DataPrint(String mode) throws CustomException {
        if(mode.equals("Circle")){
            System.out.print("Answer : ");
            basket = circleCalculator.CalculateCircle();
        }else{
            System.out.print("Answer : ");
            basket = calculator.calculateOperations();
        }
    }

    @Override
    public void exited() {
        System.out.println("This program will be down.");
        System.exit(0);
    }

    @Override
    public void remove() {
        System.out.println("First Element : " + basket.get(0) + "removed.");
        basket.remove(0);

    }

    @Override
    public void inquiry() {
        System.out.print("Basket Status : " );
        for (Integer i : basket) {
            System.out.print(i + " ");
        }
    }
}

