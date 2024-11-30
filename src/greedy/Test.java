package greedy;

class Test {
   String name;

   void display(Test t){
       t.name= "Akash";
       t = null;
   }

    public static void main(String[] args) {
        Test t = new Test();
        t.name = "Ash";
        t.display(t);
        System.out.println(t.name);
    }

}

class Demo{
    public static void main(String[] args) {
        String str = "Java";
        System.out.println(str.hashCode());
        str = str.concat("Programming Language");
        System.out.println(str.hashCode());
    }
}

