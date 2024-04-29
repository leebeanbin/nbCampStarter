package spartaCalculator.weekOne.cooking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecipeTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CollectionSelector cs = new CollectionSelector();
        PrintResult pr = new PrintResult();

        // Type
        String typeName = br.readLine();
        cs.setType(typeName);

        String menu = br.readLine();
        int orders = 1;


        while(true){
            String step = br.readLine();
            if(step.equals("끝")){
                break;
            }

            if(!typeName.equals("Map")){
                cs.add(step);
            }else{
                cs.addToMap(step, orders);
            }
            orders++;
        }
        System.out.println("[ " + typeName + " ]" + menu);
        pr.get(typeName);



    }
}
