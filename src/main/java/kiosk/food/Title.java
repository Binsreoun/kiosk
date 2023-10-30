package main.java.kiosk.food;

import java.util.ArrayList;

public class Title extends Menu {
    public static int numder = 1;
    private int menuNumder = 1;
    private int seq;
    private ArrayList<Food> menus = new ArrayList<>();

    public Title(String name, String explanation) {
        super(name, explanation);
        this.seq = numder++;
    }

    public void setMenus(String name, double price, String explanation) {
        this.menus.add(new Food(name, price, explanation));
        this.menuNumder++;
    }

    public Food getMenus(int numder) {
        return this.menus.get(numder);
    }

    public ArrayList<Food> getMenusList() {
        return this.menus;
    }

    public int getSeq() {
        return seq;
    }

    public int getMenuNumder() {
        return menuNumder;
    }

}
