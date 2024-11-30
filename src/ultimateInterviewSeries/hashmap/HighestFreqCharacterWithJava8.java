
package ultimateInterviewSeries.hashmap;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HighestFreqCharacterWithJava8 {

    public static void main(String[] args) {
        String s = "banana";
        Map<String, Long> freqMap = Stream.of(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(freqMap);

        String hfc = freqMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()).get(0);
        System.out.println("Highest Freq character is : "+hfc);
    }

}
