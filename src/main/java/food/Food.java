package main.java.food;


public class Food extends Menu{
    private double price;

    public Food(String name, double price, String explanation,int numder) {
        super(name, explanation);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

}
