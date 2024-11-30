package Arrays_String_FINAL;

import java.util.stream.IntStream;

public class SegmentedSieve {
    public static void main(String[] args) {

//        for(int i=2; i<=100; i++){
//
//        }
        int x = 2;
        boolean b = IntStream.rangeClosed(2, (int) Math.sqrt(x))
                .noneMatch(i -> x % i == 0);
        System.out.println(b);
    }
}
