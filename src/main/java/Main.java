package main.java;

import main.java.food.Title;
import main.java.order.Order;
import main.java.service.KioskService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Title> foodList = new ArrayList<>();
        Order order = new Order();
        KioskService kioskService = new KioskService();
        kioskService.menuPanMaking(foodList);
        kioskService.kioskStart(foodList, order);
    }
}