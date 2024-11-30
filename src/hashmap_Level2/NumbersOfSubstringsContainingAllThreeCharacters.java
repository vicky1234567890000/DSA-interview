package hashmap_Level2;

public class NumbersOfSubstringsContainingAllThreeCharacters {

    public static void main(String[] args){

        String str = "abcabc";
        int count = 0;

        for(int i=0;i<str.length();i++){
            int a=0,b=0,c=0;
            for(int j=i;j<str.length();j++){
                if(str.charAt(j) == 'a') a++;
                else if(str.charAt(j) == 'b') b++;
                else if(str.charAt(j) == 'c') c++;
                if(a>0 && b>0 && c>0) count++;
            }

        }

        System.out.println(count);
    }
}
