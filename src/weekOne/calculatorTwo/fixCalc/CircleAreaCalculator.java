package weekOne.calculatorTwo.fixCalc;

public class CircleAreaCalculator{
    private double radius;

    public CircleAreaCalculator(double radius) {
        this.radius = radius;
    }

    public Double calculateArea() {
        return Math.PI * radius * radius;
    }
}
