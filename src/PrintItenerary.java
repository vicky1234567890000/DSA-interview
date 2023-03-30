import java.util.HashMap;
import java.util.Scanner;

public class PrintItenerary {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int no_of_pair_of_src_des = sc.nextInt();

        HashMap<String,String> map = new HashMap<>();
        for(int i=0;i<no_of_pair_of_src_des;i++){
            String s1 = sc.next();
            String s2 = sc.next();
            map.put(s1,s2);
        }
        System.out.println(map);

        HashMap<String,Boolean> psrc = new HashMap<>();
        for(String src : map.keySet()){
            String dest = map.get(src);
            psrc.put(dest,false);

            if(!psrc.containsKey(src)){
                psrc.put(src,true);
            }
        }

        String src = "";
        for(String str : psrc.keySet()){
            if(psrc.get(str)){
                src = str;
                break;
            }
        }

        while(true){
            if(map.containsKey(src)){
                System.out.print(src+" -> ");
                src = map.get(src);
            }
            else{
                System.out.print(src+" . ");
                break;
            }
        }

    }
}
