package finalCalculator;

import java.util.List;

public abstract class Calculator {
    private List<Double> results; // 각 계산 클래스에 연산 후 받은 값을 저장하기 위한 List

    public Calculator(List<Double> result) {
        this.results = result;
    }

    public List<Double> getResults() {
        return results;
    }

    public void setResults(List<Double> results) {
        this.results = results;
    }


    abstract void remove(Object remove);

    abstract void inquiry(Object query);

}
