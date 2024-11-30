import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Interview1 {
    public static void main(String[] args) {

//        int[] myArr = {5,7,7,6,6,4};
//
//        int[] myArr2 = {7,7,6,6,4,4};
//
//        Optional<Integer> largetSingleNumber = Arrays.stream(myArr2)
//                .boxed()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet()
//                .stream()
//                .filter(e -> e.getValue() == 1)
//                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
//                .map(Map.Entry::getKey)
//                .findFirst();
//
//        largetSingleNumber.ifPresentOrElse(
//                num -> System.out.println("Largest single number is " + num),
//                () -> System.out.println("No largest single number present")
//
//        );

        // op =
        //hollo werld
        String str = "hello IntelliJ"; // eoiei ieioe




        char[] chars = str.toCharArray();

        int i=0;
        int j=str.length() -1;

        while(i < j){

            if((chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') &&
                    (chars[j] == 'a' || chars[j] == 'e' || chars[j] == 'i' || chars[j] == 'o' || chars[j] == 'u')){
                swap(chars,i,j);
                i++;
                j--;
            } else if(chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u'){
               j--;
            } else if(chars[j] == 'a' || chars[j] == 'e' || chars[j] == 'i' || chars[j] == 'o' || chars[j] == 'u'){
                i++;
            }else {
                i++;
                j--;
            }
        }

        String s = new String(chars);
        System.out.println(s);

    }

    private static void swap(char[] ch, int i, int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

}
