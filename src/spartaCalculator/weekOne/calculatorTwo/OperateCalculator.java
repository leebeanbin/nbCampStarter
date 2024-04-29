package spartaCalculator.weekOne.calculatorTwo;

import spartaCalculator.weekOne.calculatorTwo.operator.*;

import java.util.ArrayList;
import java.util.List;

public class OperateCalculator{
    // 생성자로 받아온 변수를 저장하기 위한 용도
    private int a;
    private int b;
    private String oper;

    // 연산자를 받아와 쓰기 위한 Operator 객체 생성

    // 계속 누적되지 않고 호출마다 db를 비워주기 위해 여기서 선언 및 정의
    private List<Double> data = new ArrayList<>();

    // 생성자
    public OperateCalculator(int a, int b, String oper) {
        this.a = a;
        this.b = b;
        this.oper = oper;
    }

    public List<Double> getData(){
        OperatorType op = OperatorType.valueOf(oper);
        double result = op.calculate(a,b);
        data.add(result);
        return data;
    }



}
