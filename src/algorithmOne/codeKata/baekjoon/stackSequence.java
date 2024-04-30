package algorithmOne.codeKata.baekjoon;

import java.util.Scanner;

public class stackSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 1부터 n까지의 정수
        int[] arr = new int[n]; // n개를 저장할 배열

        // 각 입력 값을 저장하는 배열
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

    }
}
