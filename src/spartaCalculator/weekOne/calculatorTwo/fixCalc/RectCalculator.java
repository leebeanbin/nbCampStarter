package spartaCalculator.weekOne.calculatorTwo.fixCalc;

public class RectCalculator{

    public double calculateRect(double a, double b, String oper){
        // oper로써 들어오는 연산자를 내가 저장해둔 단어로 매핑하여 연산을 실시한다.
        switch (oper){
            case "+":
                oper = "PLUS";
                break;
            case "-":
                oper = "MINUS";
                break;
            case "*":
                oper = "MULTIPLY";
                break;
            case "/":
                oper = "DIVIDE";
                break;
            case "%":
                oper = "REST";
                break;
        }
        Operators op = Operators.valueOf(oper);
        return op.calculate(a, b);
    }
}
