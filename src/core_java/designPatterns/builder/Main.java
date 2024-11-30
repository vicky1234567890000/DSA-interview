package core_java.designPatterns.builder;

public class Main {
    public static void main(String[] args) {

        User user = new User.UserBuilder()
                .setId(1)
                .setName("Abhisek")
                .setEmail("abc@gmail.com")
                .build();
        System.out.println(user);
    }
}
