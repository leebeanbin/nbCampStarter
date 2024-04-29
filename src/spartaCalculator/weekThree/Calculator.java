package spartaCalculator.weekThree;

import spartaCalculator.weekThree.opers.AbstractOperation;

public class Calculator{
    private AbstractOperation abs;

    public Calculator(AbstractOperation abs) {
        this.abs = abs;
    }

    public void setAbs(AbstractOperation abs) {
        this.abs = abs;
    }

    public double calculate(int a, int b){
        double ans = 0;
        ans = abs.operate(a,b);
        return ans;
    }
}
