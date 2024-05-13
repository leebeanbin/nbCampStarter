package finalCalculator;

public class MultiplyOperator<T extends Number> implements Operator<T> {

    private final Class<T> type;

    public MultiplyOperator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T operate(T a, T b) {
        double result = a.doubleValue() * b.doubleValue();
        // 제네릭은 말 그대로 널리 사용이되는 타입으로, 사칙연산 나누기 사칙연산의
        // 느낌처럼 받아들여지게 됩니다.


        return NumberConversionUtils.convertNumberToType(result, type);
    }
}
