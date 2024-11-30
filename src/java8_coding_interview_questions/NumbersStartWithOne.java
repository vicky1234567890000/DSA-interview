package java8_coding_interview_questions;

import java.util.List;

public class NumbersStartWithOne {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(2, 30, 1, 11, 100, 40, 10);

        List<String> stringList = integerList.stream()
                .map(i -> i + "")
                .filter(s -> s.startsWith("1"))
                .toList();

        System.out.println(stringList);
    }
}
