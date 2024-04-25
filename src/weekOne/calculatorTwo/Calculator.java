package weekOne.calculatorTwo;

import weekOne.calculatorTwo.operator.Operator;

import java.util.List;

public class Calculator implements Service{

    // mode의 Interface
    private double ans;
    private  Service service;
    private Operator oper;
    private List<Double> data;

    // 어떤 모드를 실행할지를 결정(DI)
    public Calculator(int a) {
        this.data = new CircleCalculator(a).calculate();

    }

    public Calculator(int a, int b, char oper) {
        this.data = new OperateCalculator(a, b, oper).calculate(oper);
    }


    public void setService(Service service) {
        this.service = service;
    }

    public List<Double> getData() {
        return data;
    }

    public double getAns() {
        return data.get(data.size()-1);
    }

    public void setAns(double ans) {
        this.ans = ans;
    }

    @Override
    public void exited() {
        System.out.println("This system will be shutdown.");
        System.exit(0);
    }

    @Override
    public void removeFirst() {
        System.out.println("Remove " + data.get(0) + ".");
        data.remove(0);
    }

    @Override
    public void inquiry() {
        System.out.print("DataBase : ");
        for (Double ele : data) {
            System.out.print(ele + " ");
        }
        System.out.println("\n");
    }
}
