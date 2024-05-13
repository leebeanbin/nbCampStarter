package finalCalculator;

import java.util.List;

// 해당 클래스를 제네릭으로 만듬으로서, 다양한 버전의 계산기로 만들 수 있는 확장성이 보장되기 때문에
// 이렇게 구성을 해줍니다.
public class ArithmeticCalculator<T extends Number> extends Calculator{
//    private final Operator operator;

    public final Class<T> type;

    public ArithmeticCalculator(List<Double> result, Class<T> type) {
        super(result);
        this.type = type;
    }

    public T calculate(T a, T b, char operator) {
        return operatorFactory(operator).operate(a, b);
    }

    private Operator<T> operatorFactory(char operator){
        // 해당 코드를 통해서 오퍼레이터가 뭔지 정해줍니다.
        OperatorType operatorType = OperatorType.fromOperator(operator);
        // new 키워드가 계속 생성되기 때문에, 메모리 면에서는 비효율적입니다.
        // 이때 싱글톤 패턴을 사용할 수 있습니다.
        return switch(operatorType){
            case ADDITION -> new AddOperator(type);
            case SUBSTRACTION -> new SubtractOperator(type);
            case MULTIPLICATION -> new MultiplyOperator(type);
            case DIVISION -> new DivideOperator(type);
//            default -> throw new ArithmeticException(); -> 이미 처리를 해줬습니다.
        };
    }

    @Override
    public void remove(Object remove){
        if(remove.equals("remove")) super.getResults().removeFirst();
    }

    @Override
    public void inquiry(Object query){
        if(query.equals("inquiry")){
            super.getResults().forEach(i -> System.out.println(i + " "));
        }
    }

    // 저장된 결과 중 입력 값보다 큰 값들을 출력/조회하는 메서드
    public void printResultGreaterThan(double lambda) {
        super.getResults().stream()
                .filter(i -> i > lambda)
                .forEach(System.out::println);
    }
}
