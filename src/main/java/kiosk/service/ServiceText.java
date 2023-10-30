package main.java.kiosk.service;

import main.java.kiosk.food.Food;
import main.java.kiosk.food.Title;
import main.java.kiosk.order.Order;
import main.java.kiosk.order.OrderFood;

import java.util.ArrayList;


public class ServiceText {
    public void menuPan(ArrayList<Title> foodList) {
        this.hello();
        this.food(foodList);
        this.order();
    }

    public void hello() {
        System.out.println("HAMPICHIPARI에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
    }

    public void food(ArrayList<Title> foodList) {
        System.out.println("[ Food MENU ]");
        for (Title title : foodList) {
            System.out.printf("%-2s %-10s %1s", title.getSeq(), title.getName(), title.getExplanation() + "\n");
        }
    }

    public void foodMenu(Title title) {
        int i = 1;
        System.out.println("[ " + title.getName() + " ]");
        for (Food f : title.getMenusList()) {
            System.out.printf("%-2s %-40s %5s %1s", i++, f.getName(), f.getPrice(), f.getExplanation() + "\n");
        }
    }

    public void foodPikMenu(int num, ArrayList<Food> menus) {
        System.out.println("\"" + menus.get(num).getName() + "\t" + menus.get(num).getPrice() + "\t" + menus.get(num).getExplanation() + "\"");
        System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
        System.out.println("1 Small(" + menus.get(num).getPrice() + ") \t\t\t 2 Large(" + (menus.get(num).getPrice() + 2000) + ")");
    }

    public void foodPikMenu2(int num2, int num, ArrayList<Food> menus) {
        if (num2 == 1) {
            System.out.println("\"" + menus.get(num - 1).getName() + "(small)" + "\t" + menus.get(num - 1).getPrice() + "\t" + menus.get(num - 1).getExplanation() + "\"");
        } else if (num2 == 2) {
            System.out.println("\"" + menus.get(num - 1).getName() + "(large)" + "\t" + (menus.get(num - 1).getPrice() + 2000) + "\t" + menus.get(num - 1).getExplanation() + "\"");
        } else {
            System.out.println("번호를 잘못입력했습니다.");
        }
    }

    public void order() {
        System.out.println("[ ORDER  MENU ]");
        System.out.printf("%-2s %-10s %1s", Title.numder, "Order", "장바구니를 확인 후 주문합니다.\n");
        System.out.printf("%-2s %-10s %1s", Title.numder + 1, "Cancel", "진행중인 주문을 취소합니다.\n");
        System.out.println();
        System.out.println("번호를 입력해주세요!");
    }

    public void getOrderList(ArrayList<OrderFood> OrderList) {
        System.out.println("[ Order ]");
        for (OrderFood f : OrderList) {
            System.out.printf("%-40s %5s %5s %1s", f.getName(), f.getSize() + " " + f.getCount() + "개", f.getRealPrice(), f.getExplanation() + "\n");
        }
        System.out.println();
    }

    public void total(Order order) {
        System.out.println("[ 총 판매상품 목록 현황 ]");
        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
        double price = 0;
        for (OrderFood a : order.getOrderTotal()) {
            System.out.println(a.getName() + "\t" + a.getSize() + "\t" + a.getCount() + "개\t" + a.getRealPrice());
            price += a.getRealPrice();
        }
        System.out.println();
        System.out.println("[ 총 판매금액 현황 ]");
        System.out.println("현재까지 총 판매된 금액은 [ " + price + " ] 입니다.");
        System.out.println();
        System.out.println("1 돌아가기");
    }

    public void getTotalList(Order order) {
        System.out.println("[ Total ]");
        System.out.println(order.price() + "원");
    }

    public void addMenuQuestion() {
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까??");
        System.out.println("1 확인 \t\t\t 2 취소");
    }

    public void addMenu() {
        System.out.println("장바구니에 추가되었습니다!");
    }

    public void cancel() {
        System.out.println("취소되었습니다!");
    }

    public void numberMistake() {
        System.out.println("번호를 잘못입력했습니다.");
    }

    public void orderMenuQuestion() {
        System.out.println("주문하시겠습니까??");
        System.out.println("1 주문 \t\t 2 매뉴 더 담기 \t\t 3 주문취소");
    }

    public void orderMenu(int num) {
        System.out.println("대기번호는 [ " + num + " ] 번 입니다.");
        System.out.println("주문이 완료되었습니다.");
        System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
    }

    public void closed() {
        System.out.println("영업이 종료되었습니다.");
    }

    public void orderCancel(){
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인 \t\t\t 2. 취소");
    }

    public void orderCancelReal(){
        System.out.println("진행하던 주문이 취소되었습니다.");
        System.out.println();
    }

    public void reverseMenuPan(){
        System.out.println("매뉴화면으로 되돌아 갑니다");
        System.out.println();
    }
}
