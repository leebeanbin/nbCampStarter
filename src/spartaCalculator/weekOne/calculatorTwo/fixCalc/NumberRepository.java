package spartaCalculator.weekOne.calculatorTwo.fixCalc;

import java.util.ArrayList;
import java.util.List;

public class NumberRepository {
    private List<Double> data = new ArrayList<>();

    public void addData(String newData){
        data.add(Double.parseDouble(newData));
    }

    public List<Double> getData() {
        return data;
    }

    public void clearData(){
        data.clear();
    }
}
