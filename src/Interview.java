import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Interview {
    public static void main(String[] args) {

        List<String> list = List.of("abhisek","rahul","david","harry","abhisek","david");

        Map<String, Long> collect = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }
}
