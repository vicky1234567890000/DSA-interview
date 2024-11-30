package core_java;


import java.util.Objects;

public class Developer {

    private String name;
    private Integer salary;
    private Integer age;

    public Developer(String name, Integer salary, Integer age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Developer developer)) return false;
        return getSalary().equals(developer.getSalary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSalary(), getAge());
    }
}
