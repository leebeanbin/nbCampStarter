package weekOne.cooking.calculatorTwo;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws CustomException {

        // 원 넓이 / 사칙연산 선택
        Scanner scanner = new Scanner(System.in);


        System.out.print("Which mode do you want to play? (Circle/Operators) : ");
        switch (scanner.nextLine()){
            case "Circle":
                System.out.print("반지름의 길이를 입력하세요 : ");
                int numOne = Integer.parseInt(scanner.next());
                CircleCalculator circleCalculator = new CircleCalculator(numOne);
                break;

            case "Operators":
                System.out.print("첫 번째 숫자를 입력하세요 : ");
                int num = Integer.parseInt(scanner.next());
                System.out.print("두 번째 숫자를 입력하세요 : ");
                int numTwo = Integer.parseInt(scanner.next());
                System.out.print("사용할 연산자를 입력하세요 : ");
                char oper = scanner.next().charAt(0);

                OperateCalculator operateCalculator = new OperateCalculator(num, numTwo,oper);
                break;
        }

        System.out.print("Continue? (exit / remove / inquiry) ");
        switch (scanner.next()) {
            case "exit":
                System.out.println("Done");
                break;
            case "remove":
                // remove first value.
                break;
            case "inquiry":
                // Basket status
                break;
            default:
                System.out.println("This is not a valid operation.");
        }


    }
}
