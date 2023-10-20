package main.java;

import java.util.ArrayList;


public class Food extends Menu{
    private double price;
    public static int numder = 1;
    private int seq;

    public Food(String name, double price, String explanation) {
        super(name, explanation);
        this.seq  = numder++;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getSeq() {
        return seq;
    }
}
