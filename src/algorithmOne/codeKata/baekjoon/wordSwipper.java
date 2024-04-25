package algorithmOne.codeKata.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class wordSwipper {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 입력될 문장의 정수 업력 받는다.
        int textLine = Integer.parseInt(br.readLine());
        List<String> result = new ArrayList<>();

        // 기본적인 문장 입력
        for(int i = 0; i < textLine; i++){
            // 각 반복마다 배열을 초기화
            String[] text = br.readLine().split(" ");

            for (String s : text) {
                result.add(reverse(s));
            }
        }

        result.forEach(element -> System.out.print(element + " "));
    }

    private static String reverse(String source){
        if(source == null || source.isEmpty()){
            return "";
        }

        String fullText = "";
        int endIndex = source.length()-1;

        for(int i = endIndex; i >= 0 ; i--){
            fullText = fullText + source.charAt(i);
        }

        return fullText;
    }
}
