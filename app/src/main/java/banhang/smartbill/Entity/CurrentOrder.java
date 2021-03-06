package banhang.smartbill.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KARATA on 06/12/2017.
 * Quản lý hóa đơn hiện tại, Tại một thời điểm chỉ tồn tại một CurrentOrder
 */

public class CurrentOrder {
    private static int Count = 0;
    private Order order;
    private Customer customer;
    private List<OrderProduct> orderProducts;

    public CurrentOrder(Order order,Customer customer)  throws OverloadObjectException{
        if(Count > 0)
            throw new OverloadObjectException();
        if(order != null && customer != null){
            Count++;
            this.order = order;
            this.customer = customer;
            orderProducts = new ArrayList<>();
        }else{
            throw new IllegalArgumentException("parameter must have value not null");
        }
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    //caculate sum money of order
    public float getSumMoney(){
        float sum = 0;
        if(orderProducts != null && orderProducts.size() > 0){
            for(OrderProduct op : orderProducts ){
                sum += op.getAmount() * op.getProduct().getUnitPrice();
            }
        }
        return sum;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Count--;
    }

    public Customer getCustomer(){
        return customer;
    }
}
