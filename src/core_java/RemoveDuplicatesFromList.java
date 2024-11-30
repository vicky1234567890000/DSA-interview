package core_java;

import java.util.List;

public class RemoveDuplicatesFromList {

    public static void main(String[] args) {
        List<Integer> intList = List.of(10,20,40,30,20);

        List<Integer> uniqueList = intList.stream().distinct().toList();
        System.out.println(uniqueList);

        if(intList.size() != uniqueList.size()){
            System.out.println("Array contains duplicates");
        }else{
            System.out.println("Array has unique elements");
        }
    }
}
