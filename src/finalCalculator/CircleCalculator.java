package finalCalculator;

import java.util.List;

public class CircleCalculator extends Calculator{
    public CircleCalculator(List<Double> result) {
        super(result);
    }

    public double calculate(int radius) {
        return Math.PI * Math.pow(radius, 2);
    }


    @Override
    void remove(Object remove) {
        if(remove.equals("remove")) super.getResults().removeFirst();

    }

    @Override
    void inquiry(Object query) {
        if(query.equals("inquiry")) super.getResults().forEach(i -> System.out.println(i + " "));
    }

}
