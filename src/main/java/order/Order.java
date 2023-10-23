package main.java.order;

import java.util.ArrayList;

public class Order {
    public ArrayList<OrderFood> OrderList = new ArrayList<>();
    private int seq = 1;
    private int menuCount = 0;
    private int totalCount = 0;
    public ArrayList<OrderFood> OrderListTotal = new ArrayList<>();

    public void setOrderList(OrderFood orderFood, String size) {
        this.OrderList.add(orderFood);
        menuCount++;
        OrderList.get(menuCount - 1).setSize(size);
        this.OrderListTotal.add(orderFood);
        totalCount++;
        OrderListTotal.get(totalCount - 1).setSize(size);
    }

    public double price() {
        double price = 0;
        for (OrderFood f : OrderList) {
            price = price + f.getRealPrice();
        }
        return price;
    }

    public ArrayList<OrderFood> getOrder() {
        return this.OrderList;
    }

    public ArrayList<OrderFood> getOrderTotal() {
        return this.OrderListTotal;
    }

    public void reset() {
        this.OrderList.clear();
        this.seq++;
        this.menuCount = 0;
    }

    public int getSeq() {
        return seq;
    }
}
