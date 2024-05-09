package session14.entity;

public class Products extends Entity<Integer> {
    private String name;
    private String description;
    private double price;

    public Products(Integer id){
        super(id);
    }

    
}
