package spartaCalculator.weekOne.calculatorTwo.fixCalc;

import spartaCalculator.weekOne.calculatorTwo.exception.CustomException;
import java.util.Scanner;

public class CalculatorApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Parser parser = new Parser();

    public static boolean start() throws CustomException {
        while (true) {
            String mode = readInput("Select Mode (Circle/Rect): ");
            parser.parseMode(mode);
            boolean shouldExit = handleCalculations(mode);
            if (shouldExit) {
                return true;
            }
        }
    }

    private static boolean handleCalculations(String mode) throws CustomException {
        while (true) {
            handleCalculationProcess(mode);

            String nextProcess = readInput("What kind of process do you want to play? (exit/remove/inquiry/change): ");
            parser.parseProcess(nextProcess);
            if (nextProcess.equals("change")) {
                break;
            } else if (nextProcess.equals("exit")) {
                return true;
            }

        }
        return false;
    }

    private static void handleCalculationProcess(String mode) throws CustomException {
        if (mode.equals("circle")) {
            String radius = readInput("Type the radius of the circle: ");
            parser.parseFirstNum(radius);
        } else {
            handleRectangleInputs();
        }

        double result = parser.executeCalculator();
        System.out.println("Here is the result: " + String.format("%.2f", result));
        System.out.println("\n");
    }

    private static void handleRectangleInputs() throws CustomException {
        String first = readInput("Type the first number of the rectangle: ");
        parser.parseFirstNum(first);

        String operation = readInput("Type the operation: ");
        parser.parseOperator(operation);

        String second = readInput("Type the second number of the rectangle: ");
        parser.parseSecondNum(second);
    }

    private static String readInput(String prompt) {
        System.out.print(prompt);
        return stringReplace(scanner.nextLine().toLowerCase());
    }

    public static String stringReplace(String input) {
        return input.replace(" ", "");
    }
}

