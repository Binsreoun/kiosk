package main.java.kiosk.food;

public class Food extends Menu {
    private double price;

    private double largePrice;

    public Food(String name, double price, String explanation) {
        super(name, explanation);
        this.price = price;
        this.largePrice = price + 2000;
    }

    public double getPrice() {
        return price;
    }

    public double getLargePrice() {
        return largePrice;
    }
}
