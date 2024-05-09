package session14.entity;

public class Customers extends Entity<Integer> {
    private String name;
    private String address;
    private String phone;
    private String email;

    public Customers(Integer id) {
        super(id);
    }

    public String getName() {
        return name;
    }
}
