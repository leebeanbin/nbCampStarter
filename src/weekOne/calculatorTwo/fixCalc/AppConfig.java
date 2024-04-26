package weekOne.calculatorTwo.fixCalc;

import weekOne.calculatorTwo.exception.CustomException;

import java.util.Scanner;

public class AppConfig {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws CustomException {

        // 원 넓이 / 사칙연산 선택 및 나머지 조건 입력
        System.out.print("Which mode do you want to play? (Circle/Area) : ");
        String mode = lower(scanner.nextLine());
        Calculator calculator = new Calculator(mode);

        System.out.println("Which process do you want to play?(exit/remove/inquiry/change)");
        String process = scanner.nextLine();
        calculator.setProcess(lower(process));
    }

    public static String lower(String mode){
        return mode.toLowerCase();
    }
}
