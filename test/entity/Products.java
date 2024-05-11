package test.entity;

public class Products extends Entity<Integer> {
    private String name;
    private String description;
    private double price;
    private int quantity;

    public Products(Integer id){
        super(id);
    }

    public Products(Integer id, String name, String description, double price, int quantity) {
        super(id);
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}