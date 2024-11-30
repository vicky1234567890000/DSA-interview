package java8_finalprep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class NthHighestNumber {
    public static void main(String[] args) {
        List<Integer> lists = Arrays.asList(1, 3);
        int n= 3;
        Optional<Integer> nthHighestSalary = lists.stream().sorted(Comparator.reverseOrder())
                .skip(n - 1)
                .findFirst();

        nthHighestSalary.ifPresentOrElse(
                num -> System.out.println(n+ "th highest number is " + num),
                () -> System.out.println("No such element in list")
        );
    }
}
