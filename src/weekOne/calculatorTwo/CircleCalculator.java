package weekOne.calculatorTwo;

import weekOne.calculatorTwo.exception.CustomException;

import java.util.ArrayList;
import java.util.List;

public class CircleCalculator{
    private int one;
    private int Area;
    // 정수값을 받아와서 저장한다.
    private static List<Integer> basket = new ArrayList<>();;

    public CircleCalculator(int one) throws CustomException {
        this.one = one;
    }

    public List<Integer> CalculateCircle() throws CustomException {
        basket.add((int)Math.PI * one * one);
        System.out.print((int)Math.PI * one * one);
        return basket;
    }

}
