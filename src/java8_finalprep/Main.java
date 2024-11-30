package java8_finalprep;
class ImmutableClass {
    private final String name;

    public ImmutableClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Normally, this class would be immutable.
}

// Subclass that introduces mutability
class MutableSubclass extends ImmutableClass {
    private String name;

    public MutableSubclass(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;  // This makes the object mutable
    }
}

public class Main {
    public static void main(String[] args) {
        ImmutableClass immutable = new MutableSubclass("InitialName");
        System.out.println("Before: " + immutable.getName());

        // Casting to MutableSubclass to modify the name
        if (immutable instanceof MutableSubclass) {
            ((MutableSubclass) immutable).setName("ChangedName");
        }

        System.out.println("After: " + immutable.getName());
    }
}

