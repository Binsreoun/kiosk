package main.java.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Order {
    ArrayList<OrderFood> OrderList = new ArrayList<>();
    private int seq = 1;

    private int menuCount = 0;
    ArrayList<OrderFood> OrderListTotal = new ArrayList<>();

    public void setOrderList(OrderFood orderFood, String size) {
        this.OrderList.add(orderFood);
        this.OrderListTotal.add(orderFood);
        menuCount++;
        OrderList.get(menuCount-1).setSize(size);
    }

    public double price(){
        double price = 0;
        for (OrderFood f :OrderList) {
            price =  price + f.getRealPrice();
        }
        return price;
    }

    public double totalPrice(){
        double price = 0;
        for (OrderFood f :OrderListTotal) {
            price =  price + f.getRealPrice();
        }
        return price;
    }

    public ArrayList<OrderFood> getOrder(){
        return this.OrderList;
    }

    public ArrayList<OrderFood> getOrderTotal(){
        return this.OrderListTotal;
    }

    public void reset(){
        this.OrderList.clear();
        this.seq++;
        this.menuCount = 0;
    }

    public int getSeq() {
        return seq;
    }
}
