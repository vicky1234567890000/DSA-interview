package core_java;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class MapVsFlatMap {
    public static void main(String[] args) {

        List<Employee> empList = List.of(new Employee(1,"Lisa",List.of(111,222)),
                new Employee(2,"Vandana",List.of(333,444)),
                new Employee(3,"Ritu",List.of(555,666)),
                new Employee(4,"Chandini",List.of(777,888)),
                new Employee(5,"Soumya",List.of(999,1000)),
                new Employee(6,"Priyanka",List.of(1000,102)),
                new Employee(7,"Tanya",List.of(103,1000))
        );

        List<List<String>> listOfStrings = List.of(List.of("kalpana","upasana"),List.of("diksha","payal"));
        List<String> stringList = listOfStrings.stream().flatMap(l -> l.stream().flatMap(s -> {
            char[] charArray = s.toCharArray();
            String[] strArr = new String[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                strArr[i] = charArray[i] + "";
            }

            return Arrays.stream(strArr);
        })).toList();

        System.out.println(stringList);
        System.out.println();

        List<List<Integer>> phLists = empList.stream().map(Employee::getPhoneNo)
                .toList();
        System.out.println(phLists);
        List<Integer> phNos = empList.stream().flatMap(emp -> emp.getPhoneNo().stream())
                .toList();
        System.out.println(phNos);
    }

    static class Employee{
        private int id;
        private String name;
        private List<Integer> phoneNo;


        public Employee(int id, String name, List<Integer> phoneNo) {
            this.id = id;
            this.name = name;
            this.phoneNo = phoneNo;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public List<Integer> getPhoneNo() {
            return phoneNo;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", phoneNo=" + phoneNo +
                    '}';
        }
    }
}
