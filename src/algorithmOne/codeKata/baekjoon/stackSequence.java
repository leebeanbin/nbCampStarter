package algorithmOne.codeKata.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class stackSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 1부터 n까지의 정수
        int index = 0;
        int start = 1; // 시작 인덱스
        int[] arr = new int[n]; // n개를 저장할 배열
        Stack<Integer> stack = new Stack<>(); // 저장할 스택
        StringBuilder sb = new StringBuilder(); // 결과 출력할 문장

        // 각 입력 값을 저장하는 배열
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        while(index < n){
            int endIndex = arr[index];
            // 각 배열 요소까지 반복해서 스택에 넣는다.
            while(start <= endIndex){
                stack.push(start);
                sb.append("+\n");
                start++;
            }

            if(stack.getLast() == endIndex){
                stack.pop();
                sb.append("-\n");
            }else{
                System.out.println("NO");
                // 뭔가 아님을 확인하고 바로 program 종료!
                System.exit(0);
                break;
            }
            index++;
        }
        System.out.println(sb);
    }
}
