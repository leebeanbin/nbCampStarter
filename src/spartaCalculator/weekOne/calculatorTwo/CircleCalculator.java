package spartaCalculator.weekOne.calculatorTwo;


import java.util.ArrayList;
import java.util.List;

public class CircleCalculator{
    private int a;
    private List<Double> data = new ArrayList<>();

    public CircleCalculator(int a) {
        this.a = a;
    }

    public List<Double> calculate() {
        Double ans = Math.PI * a * a;
        data.add(ans);
        return data;
    }

}
