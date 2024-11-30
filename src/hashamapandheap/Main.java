package hashamapandheap;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Comparator<Employee> salComp = Comparator.comparing(Employee::getSal).reversed();

    }
}
