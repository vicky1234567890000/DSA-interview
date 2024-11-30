package core_java;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        exampleSerialization();
        exampleReflection();

        CopyOnWriteArrayList<Integer> list1 = new CopyOnWriteArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        Iterator<Integer> iterator1 = list1.iterator();
        while(iterator1.hasNext()){
            if(iterator1.next()==2){
                //iterator1.remove();
                list1.add(4);
            }
        }

        System.out.println(list1);

        ConcurrentHashMap<String,Integer> cmap = new ConcurrentHashMap<>();
        cmap.put("first",1);
        cmap.put("second",2);
        cmap.put("third",3);

        Iterator<String> iterator = cmap.keySet().iterator();

        while(iterator.hasNext()){
            String key = iterator.next();
            //System.out.println(iterator.next());
            if(key.equals("first")){
                cmap.put("fourth",4);
                //iterator.remove();
            }
        }
        System.out.println(cmap);

        Map<String,Integer> map = new HashMap<>();

        map.put("Ritika",1000);
        map.put("Janvi",1200);
        map.put("Kriti",1000);
        map.put("Anuradha",2500);
        map.put("Upasana",2500);
        map.put("Gitanjali",1200);

        Map.Entry<Integer, List<String>> maxSalEmps = getNthMaxSalEmps(map,2);

        System.out.println(maxSalEmps.getKey() + " " + maxSalEmps.getValue());


        Department dept1 = new Department(1,"SDE", List.of(new Employee(100,"Trisha",1000),
                new Employee(101,"Anisha",1500),new Employee(102,"Gargi",1200)));
        Department dept2 = new Department(2,"SDET", List.of(new Employee(103,"Rani",2000),
                new Employee(104,"Ankita",1500),new Employee(105,"Shalini",2000)));
        Department dept3 = new Department(3,"INFRA", List.of(new Employee(106,"Jasmin",1600),
                new Employee(110,"Jasmin",2000),new Employee(111,"Anindita",2000),
                new Employee(107,"Varsha",2000),new Employee(102,"Huma",1100)));

        List<Employee> employees = Stream.of(dept1, dept2, dept3)
                .flatMap(dept -> dept.getEmployees().stream())
                .sorted(Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getEmpName))
                .toList();

        System.out.println(employees);

        List<Map.Entry<Integer, List<Employee>>> entries = Stream.of(dept1, dept2, dept3)
                .flatMap(dept -> dept.getEmployees().stream())
                .sorted(Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getEmpName))
                .collect(Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Function.identity(), Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .toList();


        for(Map.Entry<Integer, List<Employee>> entry : entries){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        String str = "anindita";
        String s = " pake ped pe paka papita pake ped pe pakde pintu";
        String[] strings = s.split(" ");

        List<Map.Entry<String, Long>> entryList = Stream.of(strings)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .toList();

        for(Map.Entry<String, Long> entry : entryList){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        char[] charArray = str.toCharArray();
        Character[] chArr = new Character[charArray.length];

        for(int i=0;i<chArr.length;i++){
            chArr[i]=charArray[i];
        }

        List<Map.Entry<Character, Long>> list = Stream.of(chArr)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .toList();

        for(Map.Entry<Character, Long> entry : list){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        //System.out.println(maxSalEmployee.getKey() + " " + maxSalEmployee.getValue());
    }

    private static Map.Entry<Integer, List<String>> getNthMaxSalEmps(Map<String, Integer> map,int n) {
        Map.Entry<Integer, List<String>> maxSalEmps = map.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                //.sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .toList()
                .get(n-1);
        return maxSalEmps;
    }

    private static void exampleReflection() {
        //SerializableSingleton.getConstructors()


    }

    private static void exampleSerialization() throws IOException, ClassNotFoundException {
        SerializableSingleton serializableSingleton = SerializableSingleton.getInstance();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Object.obj"));
        objectOutputStream.writeObject(serializableSingleton);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Object.obj"));
        SerializableSingleton deSerializableSingleton = (SerializableSingleton) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(serializableSingleton.hashCode());
        System.out.println(deSerializableSingleton.hashCode());
    }
}
