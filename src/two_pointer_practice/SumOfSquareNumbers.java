package two_pointer_practice;

public class SumOfSquareNumbers {
    public static void main(String[] args) {
        int c = 5;
        System.out.println(judgeSquareSum(c));

    }

    private static boolean judgeSquareSum(int c) {
        long l = 0;
        long r = (long)Math.sqrt(c);

        while(l <= r){
            long sum = l*l + r*r;

            if(sum < c){
                l++;
            } else if(sum > c){
                r--;
            } else{
                return true;
            }
        }
        return false;
    }
}
