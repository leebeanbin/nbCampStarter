package weekOne.cooking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recipe {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String menu = br.readLine();
        String[] recipe = new String[10];
        float rate = Float.parseFloat(br.readLine());

        for(int i = 0; i < 10; i++){
            String steps = br.readLine();
            recipe[i] = steps;
        }

        System.out.println("[" + menu + "]");

        System.out.println("Rate : " + (int)rate + "(" + ((int)rate  * 100/5.0)+"%)");
        for (int j = 0; j < 10; j++){
            System.out.println((j+1) +". "+ recipe[j]);
        }

    }
}
