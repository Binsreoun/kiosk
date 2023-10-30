package main.java.kiosk.order;

import main.java.kiosk.food.Menu;

public class OrderFood extends Menu {
    private String size;
    private int count = 1;
    private double realPrice;

    public OrderFood(String name, double realPrice, String explanation) {
        super(name, explanation);
        this.realPrice = realPrice;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCount() {
        return count;
    }

    public void setCount() {
        this.count++;
    }

    public double getRealPrice() {
        return realPrice * count;
    }

}
