package weekOne.calculatorTwo;

import weekOne.calculatorTwo.exception.CustomException;

import java.util.Scanner;

public class App {
    static int swch = 0;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws CustomException {

        IntegratedService integratedService;

        // 원 넓이 / 사칙연산 선택
        System.out.print("Which mode do you want to play? (Circle/Operators) : ");
        String mode = scanner.nextLine();
        while(true){
            switch (mode){
                case "Circle":
                    while(swch != 1){
                        circleLoop();
                    }
                    break;

                case "Operators":
                    while(swch != 1){
                        rectLoop();
                    }
                    break;
            }
        }
    }

    public static void circleLoop() throws CustomException {
        System.out.print("반지름의 길이를 입력하세요 : ");
        int numOne = Integer.parseInt(scanner.next());

        IntegratedService integratedService = new IntegratedService(numOne);
        integratedService.DataPrint("Circle");
        otherProcess(integratedService);
    }

    public static void rectLoop() throws CustomException{
        System.out.print("첫 번째 숫자를 입력하세요 : ");
        int num = Integer.parseInt(scanner.next());
        System.out.print("두 번째 숫자를 입력하세요 : ");
        int numTwo = Integer.parseInt(scanner.next());
        System.out.print("사용할 연산자를 입력하세요 : ");
        char oper = scanner.next().charAt(0);

        IntegratedService integratedService = new IntegratedService(num, numTwo, oper);
        integratedService.DataPrint("Operators");
        otherProcess(integratedService);
    }

    public static void otherProcess(IntegratedService integratedService){
        System.out.println();
        System.out.print("Continue? (exit / remove / inquiry) ");
        switch (scanner.next()) {
            case "exit":
                swch++;
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
        System.out.println();
    }
}
