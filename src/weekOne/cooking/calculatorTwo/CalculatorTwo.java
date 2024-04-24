package weekOne.cooking.calculatorTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorTwo{
    // 정수값을 받아와서 저장한다.
    private int one;
    private int two;
    private char oper;
    private Character[] opers = {'+', '-', '*', '/'};
    private static List<Integer> basket;

    // 각 변수, 연산자를 받아서 저장하기 위한 생성자
    public CalculatorTwo(int one, int two, char oper) throws CustomException {
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

    public int calculate() throws CustomException{
        int res = 0;

        while(true){
            switch (oper) {
                case '+':
                    res = one + two;
                    break;
                case '-':
                    res = one - two;
                    break;
                case '/':
                    res = one / two;
                    break;
                case '*':
                    res = one * two;
                    break;
                default:
                    throw new CustomException("This Operation is not supported.");
            }
            // 결과값 저장 및 반환
            basket.add(res);
            return res;
        }
    }

    public void remove(){
        // remove first value.
        System.out.println("Remove" + basket.get(0));
        basket.remove(0);

    }

    public void inquiry(){
        System.out.print("Basket status : ");
        for (Integer element : basket) {
            System.out.print((int)element + " ");
        }
        System.out.println("\n");
    }


    // Getter & Setter
    public int getOne() {
        return one;
    }

    public void setOne(int one) {
        this.one = one;
    }

    public int getTwo() {
        return two;
    }

    public void setTwo(int two) {
        this.two = two;
    }

    public char getOper() {
        return oper;
    }

    public void setOper(char oper) {
        this.oper = oper;
    }

    public static List<Integer> getBasket() {
        return basket;
    }

    public static void setBasket(List<Integer> basket) {
        CalculatorTwo.basket = basket;
    }
}
