package finalCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class App {
    static List<Double> results = new ArrayList<>();
    static Calculator calculator = new Calculator();

    public static void main(String[] args) throws IOException {
        int index = 0;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
            results.add(index, result);

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String remove = br.readLine();
            remove(remove);
            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            String inquiry = br.readLine();
            inquiryProgram(inquiry);
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String next = br.readLine();
            flag = exitProgram(next);
        }


    }

    private static boolean exitProgram(Object next){
        return next.equals("exit");
    }


    private static void inquiryProgram(Object inquiry){
        if(inquiry.equals("y")){
            calculator.getResults()
                    .forEach(i -> System.out.println(i + " "));
        }
    }

    private static void remove(Object remove){
        if(remove.equals("y")) calculator.getResults().removeFirst();
    }
}
