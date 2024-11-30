package two_pointer_practice_part_2;

public enum SingletonEnum {
    INSTANCE;

    public void print(){
        System.out.println("print called.");
    }

    public static void main(String[] args) {
        SingletonEnum obj = SingletonEnum.INSTANCE;
        obj.print();
    }

}
