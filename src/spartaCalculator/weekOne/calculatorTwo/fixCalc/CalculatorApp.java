package spartaCalculator.weekOne.calculatorTwo.fixCalc;

import spartaCalculator.weekOne.calculatorTwo.exception.CustomException;
import java.util.Scanner;

public class CalculatorApp {

    public static boolean start() throws CustomException{
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Select Mode (Circle/Rect) : ");
        String mode = stringReplace(scanner.nextLine());
        parser.parseMode(mode);

        if(mode.equals("circle")){
            System.out.print("Type the radius of the circle: ");
            String radius = stringReplace(scanner.nextLine());

            parser.parseFirstNum(radius);
        }else{
            System.out.print("Type the first number of the rectangle: ");
            String first = stringReplace(scanner.nextLine());
            parser.parseFirstNum(first);

            System.out.print("Type the operation : ");
            String operation = stringReplace(scanner.nextLine());
            parser.parseOperator(operation);

            System.out.print("Type the second number of the rectangle: ");
            String second = stringReplace(scanner.nextLine());
            parser.parseSecondNum(second);
        }

        String result = String.format("%.2f", parser.executeCalculator());
        System.out.println("Here is the result: " + result);

        return true;
    }

    public static String stringReplace(String input){
        return input.replace(" ", "");
    }
}
