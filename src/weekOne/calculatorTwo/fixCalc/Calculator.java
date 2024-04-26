package weekOne.calculatorTwo.fixCalc;

import weekOne.calculatorTwo.Service;
import weekOne.calculatorTwo.exception.CustomException;

import java.util.*;

public class Calculator implements Service {
    protected ArithmeticCalculator arithmeticCalculator;
    protected CircleAreaCalculator circleAreaCalculator;
    protected List<Double> Basket = new ArrayList<>();
    private String process;

    Scanner scanner = new Scanner(System.in);

    public Calculator() {}

    public Calculator(String mode) throws CustomException {
        if(mode.equals("circle")){
            System.out.print("please enter the radius of the circle : ");
            Area(scanner.nextDouble());
        }else if(mode.equals("area")){
            System.out.print("please enter the length of vertical line : ");
            double vertical = scanner.nextDouble();
            System.out.print("please enter the length of horizontal line : ");
            double horizontal = scanner.nextDouble();
            System.out.print("please enter the Operator for Calculation : ");
            String operator = scanner.next();
            Rect(vertical, horizontal, operator);
        }else{
            throw new CustomException("Please enter a valid mode");
        }
    }

    public void Area(double raidus){
        circleAreaCalculator = new CircleAreaCalculator(raidus);
        Basket.add(circleAreaCalculator.calculateArea());
        System.out.println("Answer is " + circleAreaCalculator.calculateArea());
    }

    public void Rect(double vertical, double horizontal, String oper){
        arithmeticCalculator = new ArithmeticCalculator(vertical, horizontal, oper);
        Basket.add(arithmeticCalculator.calculateArithm());
        System.out.println("Answer is " + arithmeticCalculator.calculateArithm());
    }

    public void setProcess(String process) {
        this.process = process;

        switch (this.process){
            case "exit":
                exited();
                break;
            case "remove":
                removeFirst();
                break;
            case "inquiry":
                inquiry();
                break;
        }
    }

    @Override
    public void exited() {
        System.out.println("Exit calculator");
        System.exit(0);
    }

    @Override
    public void removeFirst() {
        System.out.println("Remove first element -> " + Basket.getFirst());
        Basket.removeFirst();
    }

    @Override
    public void inquiry() {
        System.out.print("Basket inquiry -> ");
        for (Double ele : Basket) {
            System.out.print(ele + " ");
        }
        System.out.println("\n");
    }
}
