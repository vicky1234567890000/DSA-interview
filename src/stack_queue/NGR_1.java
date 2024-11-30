package stack_queue;

import java.util.Arrays;
import java.util.Stack;

public class NGR_1 {

    public static void main(String[] args){

        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        int[] res = nextGreaterElement(nums1,nums2);

        for(int x : res){
            System.out.print(x+" ");
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> s = new Stack<>();
        int[] ngr = new int[nums2.length];
        int[] res = new int[nums1.length];

        ngr[ngr.length-1] = nums2.length;
        s.push(nums2.length-1);

        for(int i=nums2.length-2; i>=0; i--){
            while(!s.isEmpty() && nums2[i] > nums2[s.peek()]){
                s.pop();
            }

            if(s.isEmpty()){
                ngr[i] = nums2.length;
            }else{
                ngr[i] = s.peek();
            }
            s.push(i);
        }


        for(int i=0;i<ngr.length;i++){
            if(ngr[i] == nums2.length){
                ngr[i] = -1;
            }
        }

//        for(int x : ngr){
//            System.out.print(x+" ");
//        }

        int nextGreaterIndex = 0;
        int index = 0;
        for(int i=0;i<nums1.length;i++){
            //int index =  Arrays.binarySearch(nums2,nums1[i]);
            for(int j=0;j<nums2.length;j++){
                if(nums2[j]==nums1[i]){
                    index = j;
                }
            }
            nextGreaterIndex = ngr[index];
            if(nextGreaterIndex == -1){
                res[i] = -1;
            }else{
                res[i] = nums2[nextGreaterIndex];
            }
        }

        return res;

    }

}
