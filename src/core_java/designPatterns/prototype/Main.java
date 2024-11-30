package core_java.designPatterns.prototype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Student s1 = new Student();
        s1.setId(1);
        s1.setName("Abhisek");



        ArrayList<String> li = new ArrayList<>();
        li.add("P");
        li.add("C");
        li.add("M");
        s1.setSubjects(li);

        Student s2 = s1.clone();

        s1.getSubjects().remove(1);

        System.out.println(s1);
        System.out.println(s2);
    }
}
