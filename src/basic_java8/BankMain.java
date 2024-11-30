package basic_java8;

import java.util.List;
import java.util.function.Function;

public class BankMain {
    public static void main(String[] args) {
        Bank b = (String::hashCode);
        System.out.println(b.checkBalance("1b"));

        Function<String,Integer> f = s -> Integer.parseInt(s)+100;
        Integer I = f.apply("100");
        System.out.println(I);

        List<String> l = List.of("1000","2000","3000","4000");
        List<Integer> integerList = l.stream().map(f).toList();
        System.out.println(integerList);
    }
}
