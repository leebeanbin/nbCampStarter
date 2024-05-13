package finalCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArithmeticCalculator<Double> arithmeticCalculator = new ArithmeticCalculator(new ArrayList<>(), Double.class);
        CircleCalculator circleCalculator = new CircleCalculator(new ArrayList<>());

        boolean flag = false;
        while(!flag){
            System.out.println("어떤 계산을 진행하시겠습니까? (사칙연산 : 1 , 원의 넓이 : 2) : ");
            int mode = Integer.parseInt(br.readLine());
            if(mode == 1){
                System.out.print("첫 번째 숫자를 입력하세요: ");
                double firstNumber = Integer.parseInt(br.readLine());
                System.out.print("두 번째 숫자를 입력하세요: ");
                double secondNumber = Integer.parseInt(br.readLine());

                System.out.print("사칙연산 기호를 입력하세요:  ");
                char operator = br.readLine().charAt(0);

                double result = arithmeticCalculator.calculate(firstNumber, secondNumber, operator);
                System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " + result );
                arithmeticCalculator.getResults().add(result);

                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                arithmeticCalculator.inquiry(br.readLine());

                System.out.println("저장된 연산결과 중 입력한 값보다 큰 값들을 조회하시겠습니까? (lambda 입력 시 조회)");
                if(Objects.equals(br.readLine(), "lambda")){
                    System.out.println("기준 값을 입력하세요 : ");
                    double lambda = Double.parseDouble(br.readLine());
                    arithmeticCalculator.printResultGreaterThan(lambda);
                }

                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                arithmeticCalculator.remove(br.readLine());
            }else{
                System.out.println("반지름을 입력해주세요 : ");
                int radius = Integer.parseInt(br.readLine());
                double result = circleCalculator.calculate(radius);

                System.out.println("반지름이 " + radius +"인 원의 넓이는 " + result +" 입니다.");
                circleCalculator.getResults().add(result);

                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                circleCalculator.inquiry(br.readLine());

                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                circleCalculator.remove(br.readLine());
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
