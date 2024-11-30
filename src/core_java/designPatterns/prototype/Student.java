package core_java.designPatterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class Student implements Cloneable{
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subjects=" + subjects +
                '}';
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        Student s = new Student();
        s.setId(this.getId());
        s.setName(this.getName());

        ArrayList<String> subjects = new ArrayList<>(this.getSubjects());
        s.setSubjects(subjects);

        return s;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    private Integer id;
    private String name;
    private List<String> subjects;


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getSubjects() {
        return subjects;
    }
}
