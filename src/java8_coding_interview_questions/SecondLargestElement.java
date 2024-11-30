package java8_coding_interview_questions;

import java.util.Comparator;
import java.util.List;

public class SecondLargestElement {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(20, 40, 10, 5, 35);

        Integer secondLargest = integerList.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().get();
        System.out.println("Second largest element is " + secondLargest);
    }
}
