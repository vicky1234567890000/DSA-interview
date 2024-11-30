package Arrays_String_FINAL;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringOccurance {

    public static void main(String[] args) {
//        String str = "abhisekdas";
//        Map<String, Long> map = Stream.of(str.split(""))
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        System.out.println(map);
        int n = 5;
        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                System.out.print("*" + " ");
            }
            System.out.println();
        }

    }
}
