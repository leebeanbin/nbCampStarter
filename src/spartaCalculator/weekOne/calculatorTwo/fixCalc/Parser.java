package spartaCalculator.weekOne.calculatorTwo.fixCalc;

import spartaCalculator.weekOne.calculatorTwo.exception.CustomException;

import java.util.regex.Pattern;

public class Parser {
    private static final String MODE_REG = "\\b(circle|rect)\\b";
    private static final String PROCESS_REG = "\\b(exit|remove|inquiry|change)\\b";
    private static final String OPERATION_REG = "[+\\-*/%]";

    private final Calculator<Object> calculator = new Calculator<>();

    public void parseMode(String mode) throws CustomException{
        if(!Pattern.matches(MODE_REG, mode)){
            throw new CustomException("Invalid mode");
        }

        if(mode.equals("circle")) calculator.setMode(new CircleCalculator());
        else calculator.setMode(new RectCalculator());
    }

    public void parseFirstNum(String firstInput) throws CustomException {
        try{
            Double.parseDouble(firstInput);
        }catch(Exception e){
            throw new CustomException("Invalid number. Please try again.");
        }

        this.calculator.setFirstNumber(Double.parseDouble(firstInput));
    }

    public void parseSecondNum(String secondInput) throws CustomException{
        try{
            Double.parseDouble(secondInput);
        }catch(Exception e){
            throw new CustomException("Invalid number. Please try again.");
        }

        this.calculator.setSecondNumber(Double.parseDouble(secondInput));
    }

    public void parseOperator(String operationInput) throws CustomException {
        if(!Pattern.matches(OPERATION_REG, operationInput)){
            throw new CustomException("This is not a valid operator ");
        }
        calculator.setOperations(operationInput);
    }

    public double executeCalculator() {
        return calculator.calculate();
    }

    public void parseProcess(String process) throws CustomException {
        if(!Pattern.matches(PROCESS_REG, process)){
            throw new CustomException("This is not a valid process");
        }

        switch (process) {
            case "exit" -> calculator.exit();
            case "remove" -> calculator.remove();
            case "inquiry" -> calculator.inquiry();
            case "change" -> {

                calculator.change();
            }
            default -> throw new IllegalStateException("Unexpected value: " + process);
        }

    }
}
