package session14.entity;

public class Customers extends Entity<Integer> {
    private String name;
    private String address;
    private String phone;
    private String email;

    public Customers(Integer id) {
        super(id);
    }

    public Customers(Integer id, String name, String address, String phone, String email) {
        super(id);
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
