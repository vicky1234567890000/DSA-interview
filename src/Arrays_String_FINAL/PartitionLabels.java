package Arrays_String_FINAL;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/partition-labels/description/
public class PartitionLabels {
    public static void main(String[] args) {

        String str = "ababcbacadefegdehijhklij";
        List<Integer> list = partitionLabels(str);
        System.out.println(list);
    }

    public static List<Integer> partitionLabels(String str) {

        List<Integer> partitions = new ArrayList<>();

        // find first and last index of first character


        for(int i=0; i<str.length(); ) {
            int startIndex = i;
            int endIndex = str.lastIndexOf(str.charAt(i));

            for (int s = startIndex + 1; s < endIndex; s++) {

                //find last index of subsequent characters
                int endIndexOfNextCharacter = str.lastIndexOf(str.charAt(s));
                if (endIndexOfNextCharacter > endIndex) {
                    endIndex = endIndexOfNextCharacter;
                }

            }
            partitions.add(endIndex - startIndex + 1);
            i = endIndex + 1;
        }
        return partitions;

    }
}
