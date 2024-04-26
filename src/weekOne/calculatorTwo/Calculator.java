package weekOne.calculatorTwo;


import java.util.List;

public class Calculator implements Service{

    // 기본적인 exit, removeFirst, inquiry 동작을 따로 Service로 구현해 상속받아
    // 해당 클래스에 Overriding 한다.
    // mode의 Interface
    private List<Double> data;

    // 어떤 모드를 실행할지를 결정 받고, 그에 따른 계산 결과를 생성자를 두개를 만들어 설계
    public Calculator(int a) {
        this.data = new CircleCalculator(a).calculate();
    }
    public Calculator(int a, int b, String oper) {
        this.data = new OperateCalculator(a, b, oper).getData();
    }

    // 얻은 data에 방금 들어간 요소를 main에서 출력하기 위한 것
    public double getAns() {
        return data.getLast();
    }

    @Override
    public void exited() {
        System.out.println("This system will be shutdown.");
        System.exit(0);
    }

    @Override
    public void removeFirst() {
        System.out.println("Remove " + data.getFirst() + ".");
        data.removeFirst();
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
