package spartaCalculator.weekOne.calculatorTwo;

import spartaCalculator.weekOne.calculatorTwo.exception.CustomException;

import java.util.Scanner;

public class App {
    static Calculator calc;
    static Scanner scanner = new Scanner(System.in);
    static int swit;
    public static void main(String[] args) throws CustomException {

        // 원 넓이 / 사칙연산 선택 및 나머지 조건 입력
        while(swit != 0){
            swit = 0;
            System.out.print("Which mode do you want to play? (Circle/Operators) : ");

            String mode = upper(scanner.nextLine());
            label:
            while (true){
                if(mode.equals("circle")){
                    System.out.print("반지름을 입력하세요 : ");
                    int num1 = Integer.parseInt(scanner.nextLine());

                    calc = new Calculator(num1);
                }else if(mode.equals("rect")){
                    System.out.print("첫번째 정수를 입력하세요 : ");
                    int num1 = Integer.parseInt(scanner.nextLine());
                    System.out.print("두번째 정수를 입력하세요 : ");
                    int num2 = Integer.parseInt(scanner.nextLine());
                    System.out.print("연산자를 입력하세요 : ");
                    String operator = scanner.nextLine();

                    calc = new Calculator(num1, num2,operator);
                }

                System.out.println("Answer : " + calc.getAns());

                System.out.print("How do you want to play? (change/exit/remove/inquiry) ");
                String query = upper(scanner.nextLine());

                switch (query) {
                    case "exit":
                        calc.exited();
                        swit++;
                        break;
                    case "remove":
                        calc.removeFirst();
                        break;
                    case "inquiry":
                        calc.inquiry();
                        break;
                    case "change":
                        break label;
                }
            }
        }
    }

    public static String upper(String mode){
        return mode.toLowerCase();
    }
}
