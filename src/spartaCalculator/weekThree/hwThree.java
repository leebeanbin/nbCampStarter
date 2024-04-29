package spartaCalculator.weekThree;

import spartaCalculator.weekThree.opers.*;

import java.util.Scanner;

public class hwThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AbstractOperation[] calc = new AbstractOperation[]{new AddOperation(), new SubstractOperation(), new MultiplyOperation(), new DivideOperation()};

        int a = sc.nextInt();
        int b = sc.nextInt();
        char oper = sc.next().charAt(0);

        System.out.println(result(calc, a, b, oper));
    }

    public static double result(AbstractOperation[] calc , int a , int b , char oper) {
        double ans = 0;
        Calculator cals;
        switch (oper){
            case '+':
                cals = new Calculator(calc[0]);
                ans = cals.calculate(a, b);
                break;
            case '-':
                cals = new Calculator(calc[1]);
                ans = cals.calculate(a, b);
                break;
            case '*':
                cals = new Calculator(calc[2]);
                ans = cals.calculate(a, b);
                break;
            case '/':
                cals = new Calculator(calc[3]);
                ans = cals.calculate(a, b);
                break;
        }
        return ans;
    }
}
