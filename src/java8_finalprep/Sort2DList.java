package java8_finalprep;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sort2DList {
    public static void main(String[] args) {
        List<List<Integer>> l = List.of(
                new ArrayList<>(List.of(2, 4, 3)),
                new ArrayList<>(List.of(3, 10, 2)),
                new ArrayList<>(List.of(10, 2, 1)),
                new ArrayList<>(List.of(-1, 0, -2))
        );

        List<List<Integer>> sortedLists = l.stream()
                .peek(list -> list.sort(Integer::compareTo))
                .collect(Collectors.toList());


         //Printing the sorted 2D list
        sortedLists.forEach(System.out::println);

        ArrayList<int[]> arr = new ArrayList<>();
        List<List<Integer>> sortFirstIndex = l.stream().sorted(Comparator.comparing(list -> list.get(0))).collect(Collectors.toList());
        System.out.println(sortFirstIndex);

        List<List<String>> strList = List.of(List.of("abhisek","das"), List.of("virat","kohli"), List.of("rohit","sharma"));
        List<Character> collect = strList.stream().flatMap(Collection::stream).flatMap(s -> s.chars().mapToObj(c -> Character.valueOf((char) c)))
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
