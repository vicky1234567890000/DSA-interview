package java8_finalprep;

import java.util.stream.IntStream;

public class CheckIfStringPalindrome {
    public static void main(String[] args) {
        String s = "hBHJF";

        boolean b = IntStream.range(0, s.length() / 2)
                .allMatch(i -> s.charAt(i) == s.charAt(s.length() - 1 - i));
        if(b) System.out.println(s + " is palindrome");
        else System.out.println(s + " is not palindrome");

        // Prime numbers
        for(int i=2; i<=100; i++){
            int finalI = i;
            boolean b1 = IntStream.rangeClosed(2, (int) Math.sqrt(i))
                    .noneMatch(x -> finalI % x == 0);

            System.out.println(finalI + "   " + b1);
        }
    }
}
