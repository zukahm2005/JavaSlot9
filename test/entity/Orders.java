package test.entity;

import java.util.Date;
import java.util.List;

public class Orders  {
    private int customerId;
    private Date createAt;

    private String paymentType;
    //1-N: Order-OrderDetail
    private List<OrderDetails> orderDetails;
    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }
    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
