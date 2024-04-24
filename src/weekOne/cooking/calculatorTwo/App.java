package weekOne.cooking.calculatorTwo;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws CustomException {

        Scanner sc = new Scanner(System.in);


        for (int i = 0 ; i < 2; i++){
            // this value is switch.
            int sw = 0;
            while (sw != 1) {
                System.out.print("첫 번째 숫자를 입력하세요 : ");
                int numOne = Integer.parseInt(sc.next());
                System.out.print("두 번째 숫자를 입력하세요 : ");
                int numTwo = Integer.parseInt(sc.next());
                System.out.print("Type in an Operation here -> ");
                char oper = sc.next().charAt(0);

                CalculatorTwo calculatorTwo = new CalculatorTwo(numOne, numTwo, oper);
                // 연산하기!
                calculatorTwo.calculate();

                System.out.print("Continue? (exit / remove / inquiry) ");
                switch (sc.next()) {
                    case "exit":
                        sw++;
                        System.out.println("Done");
                        break;
                    case "remove":
                        // remove first value.
                        calculatorTwo.remove();
                        break;
                    case "inquiry":
                        // Basket status
                        calculatorTwo.inquiry();
                        break;
                    default:
                        System.out.println("This is not a valid operation.");
                }


            }
        }
    }
}
