package spartaCalculator.weekOne.calculatorTwo.fixCalc;

import java.util.ArrayList;
import java.util.List;

public class Calculator<T>{

    private T mode;
    private double radius;
    protected double firstNumber;
    protected double secondNumber;
    protected String operatorName;

    // 계속 누적되지 않고 호출마다 db를 비워주기 위해 여기서 선언 및 정의
    private List<Double> data = new ArrayList<>();

    public Calculator(){}

    public double getRadius() {
        return radius;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setMode(T mode) {
        this.mode = mode;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    // 일반 사각형 그리기의 경우 operName을 저장한다.
    public void setOperations(String operName) {
        this.operatorName = operName;
    }

    public List<Double> getData() {
        return data;
    }

    public double calculate() {
        double answer;
        if(mode instanceof  CircleCalculator){
            answer = ((CircleCalculator) mode).calculateCircle(firstNumber);
            data.add(answer);
        }else{
            answer = ((RectCalculator)mode).calculateRect(firstNumber,secondNumber,operatorName);
            data.add(answer);
        }
        return answer;
    }


}
