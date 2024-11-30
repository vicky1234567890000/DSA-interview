import java.util.List;

import static java.util.Collections.list;

public class TestThread extends Thread{

    public static void main(String[] args) {

    int x=6;
    int y=0;

    --x;

    for(x=5; x >y++; --x){
        System.out.println(x * y);
        for(int z = 1; z < --x; z++){
            System.out.println(x * y * z);
        }
    }
        System.out.println(x);
        System.out.println(y);
    }



}
