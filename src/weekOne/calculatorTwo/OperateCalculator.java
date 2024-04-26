package weekOne.calculatorTwo;

import weekOne.calculatorTwo.operator.*;

import java.util.ArrayList;
import java.util.List;

public class OperateCalculator{
    // 생성자로 받아온 변수를 저장하기 위한 용도
    private int a;
    private int b;
    private char oper;

    // 연산자를 받아와 쓰기 위한 Operator 객체 생성
    private Operator operator;

    // 계속 누적되지 않고 호출마다 db를 비워주기 위해 여기서 선언 및 정의
    private List<Double> data = new ArrayList<>();

    // 생성자
    public OperateCalculator(int a, int b, char oper) {
        this.a = a;
        this.b = b;
        this.oper = oper;
    }

    // 입력되는 연산자에 따라 Operator 객체를 그 안에 구현되어 있는 내부 연산 객체와 연결
    public List<Double> calculate(char oper) {
        switch (oper) {
            case '+':
                operator = new AddOperator();
                break;
            case '-':
                operator = new SubtractOperator();
                break;
            case '*':
                operator = new MultiplyOperator();
                break;
            case '/':
                operator = new DivideOperator();
                break;
        }
        // 해당 클래스 내의 List에 데이터를 저장 후 return
        data.add(operator.operate(a, b));
        return data;
    }
}
