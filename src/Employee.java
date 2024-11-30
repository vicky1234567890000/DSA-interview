import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Employee {

    private LocalDateTime logoutTime;

    @Override
    public String toString() {
        return "Employee{" +
                "logoutTime=" + logoutTime +
                '}';
    }

    public Employee(LocalDateTime logoutTime) {
        this.logoutTime = logoutTime;
    }

    public static void main(String[] args) {

        Employee e1 = new Employee(LocalDateTime.of(2024,07,07,18,00));
        Employee e2 = new Employee(LocalDateTime.of(2024,07,07,19,00));
        Employee e3 = new Employee(LocalDateTime.of(2024,07,07,17,00));
        Employee e4 = new Employee(LocalDateTime.of(2024,07,07,20,00));


        List<List<Employee>> empList = new ArrayList<>();

        List<Employee> emps = new ArrayList<>();
        emps.add(e1);
        emps.add(e2);
        emps.add(e3);
        emps.add(e4);

        ArrayList<Employee> beforeLogout = new ArrayList<>();
        ArrayList<Employee> afterLogout = new ArrayList<>();
        for(Employee e : emps){
            if(e.logoutTime.getHour() <= 18){
                beforeLogout.add(e);
            } else{
                afterLogout.add(e);
            }
        }
       empList.add(beforeLogout);
        empList.add(afterLogout);
        System.out.println(empList);




    }
}
