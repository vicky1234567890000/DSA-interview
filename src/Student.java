import java.util.ArrayList;
import java.util.List;

public final class Student {

    private final int id;
    private final String name;

    private final Address address;

    private final List<String> subjects;

    public Student(int id, String name, Address address, List<String> subjects) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.subjects = new ArrayList<>(subjects);;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return new Address(address);
    }

    public List<String> getSubjects() {
        return new ArrayList<>(subjects);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", subjects=" + subjects +
                '}';
    }
}
