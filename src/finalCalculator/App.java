package finalCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Calculator calculator = new Calculator(new ArrayList<>(), new ArrayList<>());

        boolean flag = false;
        while(!flag){
            System.out.println("어떤 계산을 진행하시겠습니까? (사칙연산 : 1 , 원의 넓이 : 2) : ");
            int mode = Integer.parseInt(br.readLine());
            if(mode == 1){
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int firstNumber = Integer.parseInt(br.readLine());
                System.out.print("두 번째 숫자를 입력하세요: ");
                int secondNumber = Integer.parseInt(br.readLine());

                System.out.print("사칙연산 기호를 입력하세요:  ");
                char operator = br.readLine().charAt(0);

                double result = calculator.calculate(firstNumber, secondNumber, operator);
                System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " + result );
                calculator.getResults().add(result);

                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                calculator.inquiryProgram(br.readLine());

                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                calculator.remove(br.readLine());
            }else{
                System.out.println("반지름을 입력해주세요 : ");
                int radius = Integer.parseInt(br.readLine());
                double result = calculator.CircleCalculate(radius);

                System.out.println("반지름이 " + radius +"인 원의 넓이는 " + result +" 입니다.");
                calculator.getCircleResults().add(result);

                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                calculator.inquiryCircle(br.readLine());

                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                calculator.removeCircle(br.readLine());
            }


            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String next = br.readLine();
            flag = exitProgram(next);
        }
    }
    private static boolean exitProgram(Object next){
        return next.equals("exit");
    }
}
