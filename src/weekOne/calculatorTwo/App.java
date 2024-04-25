package weekOne.calculatorTwo;

import weekOne.calculatorTwo.exception.CustomException;

import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws CustomException {

        IntegratedService integratedService;

        // 원 넓이 / 사칙연산 선택
        System.out.print("Which mode do you want to play? (Circle/Operators) : ");
        String mode = scanner.nextLine();
        switch (mode){
            case "Circle":
                System.out.print("반지름의 길이를 입력하세요 : ");
                int numOne = Integer.parseInt(scanner.next());

                integratedService = new IntegratedService(numOne);
                integratedService.DataPrint(mode);

                break;

            case "Operators":
                System.out.print("첫 번째 숫자를 입력하세요 : ");
                int num = Integer.parseInt(scanner.next());
                System.out.print("두 번째 숫자를 입력하세요 : ");
                int numTwo = Integer.parseInt(scanner.next());
                System.out.print("사용할 연산자를 입력하세요 : ");
                char oper = scanner.next().charAt(0);

                integratedService = new IntegratedService(num, numTwo, oper);
                integratedService.DataPrint(mode);
                break;
        }





    }

    public static void otherProcess(IntegratedService integratedService){
        System.out.print("Continue? (exit / remove / inquiry) ");
        switch (scanner.next()) {
            case "exit":
                integratedService.exited();
                break;
            case "remove":
                // remove first value.
                integratedService.remove();
                break;
            case "inquiry":
                // Basket status
                integratedService.inquiry();
                break;
            default:
                System.out.println("This is not a valid operation.");
        }
    }
}
