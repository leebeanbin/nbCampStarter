package spartaCalculator.weekOne.calculatorTwo;

public enum OperatorType {
    PLUS{
        @Override
        public double calculate(double a, double b) {
            return a + b;
        }
    },
    MINUS{
        @Override
        public double calculate(double a, double b) {
            return a-b;
        }
    },
    MULTIPLY{
        @Override
        public double calculate(double a, double b) {
            return a*b;
        }
    },
    DIVIDE{
        @Override
        public double calculate(double a, double b) {
            return a/b;
        }
    },
    REST{
        @Override
        public double calculate(double a, double b) {
            return a%b;
        }
    };
    public abstract double calculate(double a, double b);
}
