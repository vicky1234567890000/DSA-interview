import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AccessOrder {
    public static void main(String[] args) throws NoSuchFieldException {
//        List<String> list = new ArrayList<>();
//        list.add("pen");
//        list.add("pencil");
//        Order order1 = new Order(1, list);
//        list = null;
//        //list.add("scale");
//        System.out.println(order1);

        Address address = new Address("odisha","India");
        List<String> subjects = new ArrayList<>();
        subjects.add("math");
        subjects.add("physics");
        subjects.add("chemistry");
        Student s1 = new Student(1, "Virat", address, subjects);
        System.out.println(s1);
        Address address1 = s1.getAddress();
        address1.setCountry("IND");
        subjects.add("biology");
        subjects = null;
        System.out.println(s1);

//        Thread virtualThreadConcept = Thread.ofVirtual().start(() -> {
//            System.out.println("virtual thread concept");
//        });
//        virtualThreadConcept.start();

        Field field = Student.class.getDeclaredField("name");
       // field.setAccessible(true);
       // field.set(this,"ABC");


        Address address2 = new Address("odisha","India");
        Address address3 = new Address("karnataka","Bangladesh");
        Address address4 = new Address("Bihar","Nepal");
        Address address5 = new Address("TamilNadu","SriLanka");
        Address address6 = new Address("WestBengal","Bangladesh");
        Address address7 = new Address("Delhi","China");

        List<String> subject1 = new ArrayList<>();
        subjects.add("math");
        subjects.add("physics");
        subjects.add("chemistry");

        List<String> subject2 = new ArrayList<>();
        subjects.add("math");
        subjects.add("physics");
        subjects.add("chemistry");

        List<String> subject3 = new ArrayList<>();
        subjects.add("math");
        subjects.add("physics");
        subjects.add("chemistry");

        List<String> subject4 = new ArrayList<>();
        subjects.add("math");
        subjects.add("physics");
        subjects.add("chemistry");

        List<String> subject5 = new ArrayList<>();
        subjects.add("math");
        subjects.add("physics");
        subjects.add("chemistry");

        List<String> subject6 = new ArrayList<>();
        subjects.add("math");
        subjects.add("physics");
        subjects.add("chemistry");

        Student s2 = new Student(2, "Honey Singh", address2, subject1);
        Student s3 = new Student(3, "Rohit", address3, subject2);
        Student s4 = new Student(4, "Bumrah", address4, subject3);
        Student s5 = new Student(5, "Surya", address5, subject4);
        Student s6 = new Student(6, "Jaishwal", address6, subject5);
        Student s7 = new Student(7, "Gill", address7, subject6);

        List<Student> students = new ArrayList<>();
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);
        students.add(s7);




//        Order order6 = new Order(1000, list);
//        Order order2 = new Order(2, list);
//        Order order3 = new Order(4000, list);
//        Order order4 = new Order(10, list);
//        Order order5 = new Order(100, list);
//
//        ArrayList<Order> listOfOrder = new ArrayList<>();
//        listOfOrder.add(order6);
//        listOfOrder.add(order2);
//        listOfOrder.add(order3);
//        listOfOrder.add(order4);
//        listOfOrder.add(order5);
//        Collections.sort(listOfOrder, Comparator.comparingInt(Order::getOrderId));
//        System.out.println(listOfOrder);




    }








}
