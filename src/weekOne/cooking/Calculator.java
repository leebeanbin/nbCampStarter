package weekOne.cooking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){

        // Repository
        int[] arr = new int[10];
        List<Integer> basket = new ArrayList<>();

        // Variables
        int window = 0;

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요 : ");
            int numOne = Integer.parseInt(sc.next());
            System.out.print("두 번째 숫자를 입력하세요 : ");
            int numTwo = Integer.parseInt(sc.next());


            //배열로 저장하여 10개가 넘으면 다시 처음부터 저장하는 방법
            int result = operation(numOne, numTwo); // 연산 결과

            arr[window] = result;
            window = (window > 9) ? 0 : window + 1;


            //리스트를 사용하여 값을 무한하게 저장하는 방법
            basket.add(result);
            nextWork(basket, arr);
            break;
        }
    }

    public static int operation(int One, int Two) {
        int res = 0;

        while(true){
            System.out.print("Type in an Operation here -> ");
            char oper = sc.next().charAt(0);

            switch (oper) {
                case '+':
                    res = One + Two;
                    break;
                case '-':
                    res = One - Two;
                    break;
                case '/':
                    res = One / Two;
                    break;
                case '*':
                    res = One * Two;
                    break;
                default:
                    System.out.println("This format is incorrect.");
                    continue;
            }
            return res;
        }
    }

    public static void nextWork(List<Integer> basket, int[] arr){
        while(true){
            System.out.print("Continue? (exit / remove / inquiry) ");
            String nextStep = sc.next();
            switch (nextStep){
                case "remove":
                    // 처음에 위치한 요소를 지운다. - List
                    basket.remove(0);
                    // 처음에 위치한 요소를 지운다. - Array
                    // 무한으로 돌면 다시 그 자리에 변수가 오기에, 0으로 바꿔주면 지운것과 같음
                    arr[0] = 0;
                    break;
                case "inquiry":
                    basket.forEach(element -> System.out.print(element + " "));
                    System.out.println();
                    System.out.println(Arrays.toString(arr));
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("This format is incorrect.");
                    continue;
            }
        }
    }
}
