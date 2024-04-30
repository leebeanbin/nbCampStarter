package spartaCalculator.weekOne.calculatorTwo.fixCalc;

public class Calculator<T> extends NumberRepository{

    private T mode;
    private double radius;
    protected double firstNumber;
    protected double secondNumber;
    protected String operatorName;

    private final NumberRepository numberRepository;

    public Calculator(NumberRepository numberRepository){
        this.numberRepository = numberRepository;
    }


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


    public double calculate() {
        double answer;
        if(mode instanceof  CircleCalculator){
            answer = ((CircleCalculator) mode).calculateCircle(firstNumber);
            String ans = String.format("%.2f", answer);
            numberRepository.addData(ans);
        }else{
            answer = ((RectCalculator)mode).calculateRect(firstNumber,secondNumber,operatorName);
            String ans = String.format("%.2f", answer);
            numberRepository.addData(ans);
        }
        return answer;
    }

    public void exit(){
        System.out.println("This program will be shut down.");
    }

    public void remove(){
        System.out.println("Removing " + numberRepository.getData().getFirst());
        numberRepository.getData().removeFirst();
    }

    public void inquiry(){
        System.out.print("Data Status : ");
        numberRepository.getData().forEach(ele -> System.out.print(ele + " "));
        System.out.println("\n");
    }

    public void change() {
        numberRepository.getData().clear();
    }
}
