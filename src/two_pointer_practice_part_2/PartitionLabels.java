package two_pointer_practice_part_2;

import java.util.ArrayList;
import java.util.List;

// Given a string, partition into maximum parts possible such each character can only appear in only 1 part.
// https://leetcode.com/problems/partition-labels/description/
public class PartitionLabels {
    public static void main(String[] args) {

        String str = "ababxdedg";
        List<Integer> maxPartitions = partitionLabels(str);
        System.out.println(maxPartitions);

    }

    private static  List<Integer> partitionLabels(String str) {
        List<Integer> partitions = new ArrayList<>();
        for(int i=0; i<str.length(); ){

            // find the start and end index of first character of each partition

            int startIndex = i;
            int endIndex = str.lastIndexOf(str.charAt(i));

            for(int s = startIndex + 1; s < endIndex; s++){

                // find the end indexof subsequent character
                int endIndexOfNextCharacter = str.lastIndexOf(str.charAt(s));

                if(endIndexOfNextCharacter > endIndex){
                    endIndex = endIndexOfNextCharacter;
                }
            }

            partitions.add(endIndex - startIndex + 1);
            i = endIndex + 1;
        }
        return partitions;
    }
}
