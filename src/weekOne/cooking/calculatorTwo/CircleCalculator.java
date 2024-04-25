package weekOne.cooking.calculatorTwo;

import java.util.List;

public class CircleCalculator implements Service{
    // 정수값을 받아와서 저장한다.
    private double one;
    private double Area;
    private static List<Double> basket;


    public CircleCalculator(int one) {
        this.one = one;
    }

    public double CalculateCircle(){
        basket.add(Math.PI * one * one);
        return Math.PI * one * one;
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
        for (Double i : basket) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }
}
