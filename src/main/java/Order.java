package main.java;

import java.util.ArrayList;
import java.util.Collections;


public class Order{
    ArrayList<Food> OrderList = new ArrayList<>();
    private double total;

    public void setOrderList(Food food) {
        this.OrderList.add(food);

        OrderList.sort((o1, o2) -> {
            int result = 1;
            if (o1.getSeq() >= o2.getSeq())
                result = -1;
            return result;
        });

        this.total = total + food.getPrice();
    }

    public void getOrderList(){
        System.out.println("[ Order ]");
        for (Food f :OrderList) {
            System.out.printf("%-40s %5s %1s",f.getName(), f.getPrice(),f.getExplanation()+"\n");
        }
        System.out.println();
        System.out.println("[ Total ]");
        System.out.println(this.total+"원");
        
    }

    public double getTotal(){
        return this.total;
    }

}
