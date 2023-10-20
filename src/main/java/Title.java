package main.java;

import java.util.ArrayList;

public class Title extends Menu {
    public static int numder = 1;
    private int seq;
    private ArrayList<Food> menus = new ArrayList<>();
    private String title = " 상품 \t\t\t\t가격 \t\t\t\t설명\n";

    public Title(String name, String explanation) {
        super(name, explanation);
        this.seq = numder++;
    }

    public void setMenus(String name, double price, String explanation) {
        this.menus.add(new Food(name, price, explanation));
    }

    public Food getMenus(int numder) {
        return this.menus.get(numder);
    }

    public int getSeq() {
        return seq;
    }

    public void foodMenu() {
        int i= 1;
        System.out.println("[ " + getName() + " ]");
        for (Food f : menus) {
            System.out.printf("%-2s %-40s %5s %1s", i++, f.getName(), f.getPrice(), f.getExplanation() + "\n");
        }

    }

    public void foodPikMenu(int num) {
        System.out.println("\""+ menus.get(num).getName()+ "\t"+menus.get(num).getPrice()+ "\"");
        System.out.println();
    }

    public void orderMenu() {
        System.out.printf("%-2s %-10s %1s", this.getSeq(), super.getName(), super.getExplanation() + "\n");
    }


}
