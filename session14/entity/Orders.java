package session14.entity;

import java.util.List;

public class Orders extends Entity<Integer> {

    private int CustomerId;
    private String createAt;
    private String paymentType;
    private List<OrderDetails> orderDetailList;

    public Orders(Integer id) {
        super(id);
        // TODO Auto-generated constructor stub
    }

    public List<OrderDetails> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetails> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

}
