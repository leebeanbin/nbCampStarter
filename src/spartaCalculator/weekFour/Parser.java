package spartaCalculator.weekFour;

import spartaCalculator.weekThree.opers.AddOperation;
import spartaCalculator.weekThree.opers.DivideOperation;
import spartaCalculator.weekThree.opers.MultiplyOperation;
import spartaCalculator.weekThree.opers.SubstractOperation;

import java.util.regex.Pattern;

public class Parser {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    private final Calculator calculator = new Calculator();

    public Parser parseFirstNum(String firstInput) throws BadInputException {
        if(!Pattern.matches(NUMBER_REG, firstInput)){
            throw new BadInputException(firstInput);
        }

        this.calculator.setFirstNumber(Integer.parseInt(firstInput));
        return this;
    }

    public Parser parseSecondNum(String secondInput) throws BadInputException{
        if(!Pattern.matches(NUMBER_REG, secondInput)){
            throw new BadInputException(secondInput);
        }

        this.calculator.setSecondNumber(Integer.parseInt(secondInput));
        return this;
    }

    public Parser parseOperator(String operationInput) throws BadInputException{
        if(!Pattern.matches(OPERATION_REG, operationInput)){
            throw new BadInputException("연산자");
        }

        switch (operationInput) {
            case "+" -> this.calculator.setOperation(new AddOperation());
            case "-" -> this.calculator.setOperation(new SubstractOperation());
            case "*" -> this.calculator.setOperation(new MultiplyOperation());
            case "/" -> this.calculator.setOperation(new DivideOperation());
        }

        return this;
    }

    public double executeCalculator() {
        return calculator.calculate();
    }
}