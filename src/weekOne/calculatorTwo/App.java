package weekOne.calculatorTwo;

import weekOne.calculatorTwo.exception.CustomException;

import java.util.Scanner;

public class App {
    static Calculator calc;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws CustomException {

        // 원 넓이 / 사칙연산 선택 및 나머지 조건 입력
        while(true){
            System.out.print("Which mode do you want to play? (Circle/Operators) : ");

            String mode = upper(scanner.nextLine());
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
                    char operator = scanner.nextLine().charAt(0);

                    calc = new Calculator(num1, num2, operator);
                }

                System.out.println("Answer : " + calc.getAns());

                System.out.print("How do you want to play? (change/exit/removeFirst/inquiry) ");
                String query = scanner.nextLine();

                if(query.equals("exit")){
                    calc.exited();
                }else if(query.equals("removeFirst")){
                    calc.removeFirst();
                } else if (query.equals("inquiry")) {
                    calc.inquiry();
                } else if (query.equals("change")) {
                    break;
                }
            }
        }
    }

    public static String upper(String mode){
        return mode.toLowerCase();
    }
}
