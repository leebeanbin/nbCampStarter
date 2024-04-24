package algorithmOne;

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
            String fullText = "";
            for (String s : text) {
                String reverse = "";
                for(int j = s.length()-1; j >= 0 ; j--){
                    reverse = reverse + s.charAt(j);
                }
                fullText = fullText + (reverse + " ");
            }
            result.add(fullText);
        }

        result.forEach(element -> System.out.println(element));
    }
}
