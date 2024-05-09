package session14.entity;

import java.sql.Date;

public class OrderDetails extends Entity<Integer> {
    public OrderDetails(Integer id) {
        super(id);
        // TODO Auto-generated constructor stub
    }

    private int orderId;
    private Date createAt;
    private Date updateAt;
    private int productId;
    private double price;
    private int quantity;

    
}
