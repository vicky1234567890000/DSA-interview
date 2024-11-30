public class Address {
    private String state;
    private String country;

    public Address(String state, String country) {
        this.state = state;
        this.country = country;
    }

    public Address(Address address) {

        this(address.getState(), address.getCountry());
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
