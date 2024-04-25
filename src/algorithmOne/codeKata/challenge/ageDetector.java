package algorithmOne.codeKata.challenge;

import java.util.Scanner;

class Solution {
    public int solution(int age) {
        int answer = 0;
        answer = (2022 - age)+1;
        return answer;
    }
}
public class ageDetector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 객체 생성 후 값을 집어 넣는다.
        Solution solution = new Solution();
        System.out.println(solution.solution(sc.nextInt()));
    }
}
