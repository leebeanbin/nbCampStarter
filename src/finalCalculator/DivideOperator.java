package finalCalculator;

public class DivideOperator<T extends Number> implements Operator<T> {

    // Class 라는 클래스도 존재합니다. 이것은 제네릭의 클래스 정보를 담고 있습니다.
    public final Class<T> type;

    public DivideOperator(Class<T> type) {
        this.type = type;
    }

    @Override
    // 컴파일러가 똑똑하게 다양한 것들을 확인하주지만, 우리 조건문에 체크 한 것들을
    // 꼼꼼하게 확인하지 않습니다. 그래서 컴파일러에게 해당 에러는 내가 고려하고 수정 했다는
    // 표시로 해당 어노테이션을 작성합니다.
    @SuppressWarnings("unchecked")
    public T operate(T a, T b) {
        if(b.doubleValue() == 0.0){
            throw new ArithmeticException("Divide by zero");
        }
        double result = a.doubleValue() / b.doubleValue();
        // 제네릭은 말 그대로 널리 사용이되는 타입으로, 사칙연산 나누기 사칙연산의
        // 느낌처럼 받아들여지게 됩니다.


        return NumberConversionUtils.convertNumberToType(result, type);
    }
}
