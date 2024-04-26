package weekOne.calculatorTwo.fixCalc;

public class ArithmeticCalculator {
    private double vertical;
    private double horizontal;
    private String oper;
    private Double answer;
    Operators opers;

    public ArithmeticCalculator(double vertical, double horizontal, String oper) {
        this.vertical = vertical;
        this.horizontal = horizontal;
        this.oper = oper;
    }

    public Double calculateArithm() {
        opers = Operators.valueOf(oper);
        answer = opers.calculate(vertical, horizontal);
        return answer;
    }
}
