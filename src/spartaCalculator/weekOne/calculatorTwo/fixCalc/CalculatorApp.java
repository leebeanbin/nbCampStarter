package spartaCalculator.weekOne.calculatorTwo.fixCalc;

import spartaCalculator.weekOne.calculatorTwo.exception.CustomException;
import java.util.Scanner;

public class CalculatorApp {
    static NumberRepository numberRepository = new NumberRepository();
    public static boolean start() throws CustomException{
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Select Mode (Circle/Rect) : ");
        String mode = stringReplace(scanner.nextLine());
        parser.parseMode(mode);

        int sign = 0;
        boolean element = false;

        while(!element){
            if(mode.equals("circle")){
                System.out.print("Type the radius of the circle: ");
                String radius = stringReplace(scanner.nextLine().toLowerCase());
                parser.parseFirstNum(radius);
            }else{
                System.out.print("Type the first number of the rectangle: ");
                String first = stringReplace(scanner.nextLine().toLowerCase());
                parser.parseFirstNum(first);

                System.out.print("Type the operation : ");
                String operation = stringReplace(scanner.nextLine().toLowerCase());
                parser.parseOperator(operation);

                System.out.print("Type the second number of the rectangle: ");
                String second = stringReplace(scanner.nextLine().toLowerCase());
                parser.parseSecondNum(second);
            }

            String result = String.format("%.2f", parser.executeCalculator());
            numberRepository.addData(result);
            System.out.println("Here is the result: " + result);

            System.out.print("What kind of process do you want to play? (exit/remove/inquiry/change) : ");
            String nextProcess = stringReplace(scanner.nextLine().toLowerCase());
            element = parser.parseProcess(nextProcess);
        }

        scanner.close();
        return element;
    }

    public static String stringReplace(String input){
        return input.replace(" ", "");
    }
}
