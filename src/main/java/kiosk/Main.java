package main.java.kiosk;

import main.java.kiosk.food.Title;
import main.java.kiosk.order.Order;
import main.java.kiosk.service.KioskService;

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