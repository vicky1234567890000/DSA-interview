package stack_queue;

import java.util.Stack;

public class LargestAreaHistogram {

    public static void main(String[] args){

        int[] arr = {6,2,5,4,5,1,6};
        int maxArea = largestAreaHistogram(arr);
        System.out.println("Largest area of the histogram is : " + maxArea);

    }
    private static int largestAreaHistogram(int[] arr) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        int maxArea = 0;

        int[] nsr = new int[arr.length];
        s1.push(arr.length-1);
        nsr[nsr.length-1] = arr.length;

        for(int i=arr.length-2;i>=0;i--){

            while(!s1.isEmpty() && arr[i] <= arr[s1.peek()]){
                s1.pop();
            }

            if(s1.isEmpty()){
                nsr[i] = arr.length;
            }else{
                nsr[i] = s1.peek();
            }

            s1.push(i);
        }

        System.out.println("nsr : ");
        System.out.println();
        for(int x : nsr){
            System.out.print(x+" ");
        }
        System.out.println();

        int[] nsl = new int[arr.length];
        s2.push(0);
        nsl[0] = -1;

        for(int i=1;i< arr.length ;i++){

            while(!s2.isEmpty() && arr[i] <= arr[s2.peek()]){
                s2.pop();
            }

            if(s2.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s2.peek();
            }

            s2.push(i);
        }

        System.out.println("nsl : ");
        System.out.println();
        for(int x : nsl){
            System.out.print(x+" ");
        }

        for(int i=0;i<arr.length;i++){

            int height = arr[i];
            int width = nsr[i] - nsl[i]-1;
            int area = height * width;

            maxArea = Math.max(maxArea,area);
        }

        return maxArea;

    }

}
