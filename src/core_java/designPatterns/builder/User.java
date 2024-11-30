package core_java.designPatterns.builder;

public class User {
    private Integer id;
    private String name;
    private String email;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    User(UserBuilder userBuilder){
        this.id = userBuilder.id;
        this.name = userBuilder.name;
        this.email = userBuilder.email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    static class UserBuilder{
        private Integer id;
        private String name;
        private String email;

        public UserBuilder setId(Integer id) {
            this.id = id;
            return this;
        }

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build(){
            User user = new User(this);
            return user;
        }

    }
}
