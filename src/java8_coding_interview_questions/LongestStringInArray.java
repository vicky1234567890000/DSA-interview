package java8_coding_interview_questions;

import java.util.List;

public class LongestStringInArray {
    public static void main(String[] args) {
        List<String> stringList = List.of("java", "springboot", "microservices");
        String s = stringList.stream()
                .reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2)
                .get();
        System.out.println(s);

    }
}
