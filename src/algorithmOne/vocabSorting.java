package algorithmOne;


/*
알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

1. 길이가 짧은 것부터
2. 길이가 같으면 사전 순으로
단, 중복된 단어는 하나만 남기고 제거해야 한다.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class vocabSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 받을 단어의 개수
        int wordAmount = Integer.parseInt(br.readLine());

        // HashSet을 사용하여 중복 단어 제거 및 스트림으로 입력 받기
        Set<String> wordDB = new HashSet<>();
        for (int i = 0; i < wordAmount; i++) {
            wordDB.add(br.readLine());
        }

        // 스트림을 사용하여 정렬 및 결과 출력
        wordDB.stream()
                .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);
    }
}
