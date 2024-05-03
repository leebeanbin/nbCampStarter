package finalCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Calculator calculator = new Calculator(new ArrayList<>());

        boolean flag = false;
        while(!flag){
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int firstNumber = Integer.parseInt(br.readLine());
            System.out.print("두 번째 숫자를 입력하세요: ");
            int secondNumber = Integer.parseInt(br.readLine());

            System.out.print("사칙연산 기호를 입력하세요:  ");
            char operator = br.readLine().charAt(0);

            double result = calculator.calculate(firstNumber, secondNumber, operator);
            System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " + result );
            calculator.getResults().add(result);

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            calculator.remove(br.readLine());

            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            calculator.inquiryProgram(br.readLine());

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String next = br.readLine();
            flag = exitProgram(next);
        }
    }
    private static boolean exitProgram(Object next){
        return next.equals("exit");
    }
}
