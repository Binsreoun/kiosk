package main.java.service;

import main.java.food.Title;
import main.java.order.Order;
import main.java.order.OrderFood;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class KioskService {
    private boolean end = false;
    ServiceText text = new ServiceText();
    Scanner sc = new Scanner(System.in);

    //메뉴판 생성
    public void menuPanMaking(ArrayList<Title> foodList) {
        foodList.add(new Title("hamburger", "한입에 다먹기 어려울껄~!"));
        foodList.add(new Title("pizza", "한조각 다먹기 어려울껄~!"));
        foodList.add(new Title("chicken", "닭다리 다먹기 어려울껄~!"));
        foodList.add(new Title("pasta", "건더기 다먹기 어려울껄~!"));
        foodList.add(new Title("risotto", "한그릇 다먹기 어려울껄~!"));
        foodList.add(new Title("drink", "한잔 다마시기 어려울껄~!"));
        foodList.get(0).setMenus("Burger from Shanghai", 8000, "상하이의 매운맛을 표현한 양파와 양상추, 토마토가 들어간 치킨버거");
        foodList.get(0).setMenus("wiper Burger", 8500, "버거의 왕이 만들었다는 케팝과 마요네즈 소스가 들어간 소고기버거");
        foodList.get(0).setMenus("Shrimp Burger", 8500, "니들이 새우맛을 알아?! 레몬과 렌치소스가 들어간 새우버거");
        foodList.get(1).setMenus("Morgherita Pizza", 20000, "어떻게 이런맛이 나오는지 모르게리따! 정통 나폴리 마르게리따피자");
        foodList.get(1).setMenus("Black Tiger Angus Ogol Chicken pizza", 23000, "육해공 전설의 토핑이 다모였다. 소고기,새우,닭만든 조화 블랙타이거앵거스오골계피자");
        foodList.get(1).setMenus("Sweet Potato Pizza", 18000, "달달한 고구마가 너무 맛있다! 단감자피자");
        foodList.get(2).setMenus("Pirate King's Golden Chicken", 19000, "해적왕이 금인줄 알고 훔쳐간 매우 맛있는 후라이드 치킨");
        foodList.get(2).setMenus("My house seasoned chicken", 20000, "집에서 해먹는것보다 더맛있네! 친청집 양념치킨");
        foodList.get(2).setMenus("Soy chicken", 20000, "짠데 달어~ 간장치킨");
        foodList.get(2).setMenus("Cheese Seasoning Chicken", 21000, "치즈 가루 뿌링 뿌링 치즈가루치킨");
        foodList.get(3).setMenus("Vongole Pasta", 12000, "기름 조개 파스타 봉골레 파스타");
        foodList.get(3).setMenus("Tomato Pasta", 13000, "뻘건거 토마토 파스타");
        foodList.get(3).setMenus("Cream Pasta", 13000, "허연거 크림 파스타");
        foodList.get(3).setMenus("rose pasta", 14000, "섞은거 로제토 파스타");
        foodList.get(4).setMenus("Tomato Risotto", 13000, "뻘건거 면 대신 밥 토마토 리조또");
        foodList.get(4).setMenus("Creamy Risotto", 13000, "허연거 면 대신 밥 크림 리조또");
        foodList.get(4).setMenus("rose risotto", 14000, "섞은거 면 대신 밥 로제 리조또");
        foodList.get(5).setMenus("coke", 2000, "코카콜라일까? 팹시일까?");
        foodList.get(5).setMenus("zero coke", 2000, "제로칼로리가 무슨 의미가 있나!");
        foodList.get(5).setMenus("sprite", 2000, "사이다일까? 스프라이트일까?");
        foodList.get(5).setMenus("zero sprite", 2000, "이왕먹을꺼 맛있는거 먹지..");
    }

    //주문시작
    public void kioskStart(ArrayList<Title> foodList, Order order) {
        while (!this.end) {
            text.menuPan(foodList);
            int orderNum = sc.nextInt();
            this.choiceMenu(orderNum, foodList, order);
        }
    }

    //메뉴선택
    public void choiceMenu(int orderNum, ArrayList<Title> foodList, Order order) {
        if (0 < orderNum && orderNum < Title.numder) {
            text.foodMenu(foodList.get(orderNum - 1));
            int menuNum = sc.nextInt();
            this.choiceMenuCheck(orderNum, menuNum, foodList, order);

        } else if (orderNum == Title.numder) {
            this.order(order);

        } else if (orderNum == Title.numder + 1) {
            text.orderCancel();
            int cancel = sc.nextInt();
            this.orderCancel(cancel,order);
        } else if (orderNum == 0) {
            text.total(order);
            int reverse = sc.nextInt();
            this.reverse(reverse);
        } else if (orderNum == 777) {
            text.closed();
            this.end = true;
        } else {
            text.numberMistake();
        }
    }

    //상품선택
    public void choiceMenuCheck(int orderNum, int menuNum, ArrayList<Title> foodList, Order order) {
        if (0 < menuNum && menuNum < foodList.get(orderNum - 1).getMenuNumder()) {
            text.foodPikMenu(menuNum - 1, foodList.get(orderNum - 1).getMenusList());
            int menuNum2 = sc.nextInt();
            this.choiceSize(orderNum, menuNum, menuNum2, foodList, order);
        } else {
            text.numberMistake();
        }
    }

    //사이즈선택
    public void choiceSize(int orderNum, int menuNum, int menuNum2, ArrayList<Title> foodList, Order order) {
        if (menuNum2 == 1) {
            text.foodPikMenu2(menuNum2, menuNum, foodList.get(orderNum - 1).getMenusList());
            text.addMenuQuestion();
            int menuNum3 = sc.nextInt();
            this.choiceSizeCheck(orderNum, menuNum, "small", menuNum3, foodList, order);
        } else if (menuNum2 == 2) {
            text.foodPikMenu2(menuNum2, menuNum, foodList.get(orderNum - 1).getMenusList());
            text.addMenuQuestion();
            int menuNum3 = sc.nextInt();
            this.choiceSizeCheck(orderNum, menuNum, "large", menuNum3, foodList, order);
        } else {
            text.numberMistake();
        }
    }

    //사이즈확인
    public void choiceSizeCheck(int orderNum, int menuNum, String size, int menuNum3, ArrayList<Title> foodList, Order order) {
        if (menuNum3 == 1) {
            this.menuCount(orderNum, menuNum, size, foodList, order);
            text.addMenu();
        } else if (menuNum3 == 2) {
            text.cancel();
        } else {
            text.numberMistake();
        }
    }

    //주문확인
    public void menuCount(int orderNum, int menuNum, String size, ArrayList<Title> foodList, Order order) {
        if (order.getOrder().isEmpty()) {
            this.notCount(orderNum, menuNum, size, foodList, order);
        } else {
            this.addOrderFood(orderNum, menuNum, size, foodList, order);
        }
    }

    //중복체크 및 갯수새기
    public void addOrderFood(int orderNum, int menuNum, String size, ArrayList<Title> foodList, Order order) {
        int cuplicateCheck = -1;
        for (int i = 0; i < order.getOrder().size(); i++) {
            if (Objects.equals(order.getOrder().get(i).getName(), foodList.get(orderNum - 1).getMenus(menuNum - 1).getName())
                    && Objects.equals(order.getOrder().get(i).getSize(), size)) {
                cuplicateCheck = i;
            }
        }
        if (cuplicateCheck == -1) {
            this.notCount(orderNum, menuNum, size, foodList, order);
        } else {
            order.getOrder().get(cuplicateCheck).setCount();
        }
    }

    //주문담기
    public void notCount(int orderNum, int menuNum, String size, ArrayList<Title> foodList, Order order) {
        if (Objects.equals(size, "small")) {
            order.setOrderList(new OrderFood(foodList.get(orderNum - 1).getMenus(menuNum - 1).getName(),
                    foodList.get(orderNum - 1).getMenus(menuNum - 1).getPrice(),
                    foodList.get(orderNum - 1).getMenus(menuNum - 1).getExplanation()
            ), size);
        } else if (Objects.equals(size, "large")) {
            order.setOrderList(new OrderFood(foodList.get(orderNum - 1).getMenus(menuNum - 1).getName(),
                    foodList.get(orderNum - 1).getMenus(menuNum - 1).getLargePrice(),
                    foodList.get(orderNum - 1).getMenus(menuNum - 1).getExplanation()
            ), size);
        }
    }

    public void orderCancel(int num,Order order) {
        if (num == 1) {
            order.reset();
            text.orderCancelReal();
        } else if (num == 2) {
            text.reverseMenuPan();
        }else {
            text.numberMistake();
        }
    }
    //뒤로가기
    public void reverse(int reverse) {
        if (reverse != 1) {
            text.numberMistake();
        }
    }

    //장바구니
    public void order(Order order) {
        text.getOrderList(order.getOrder());
        text.getTotalList(order);
        text.orderMenuQuestion();
        int menuNum3 = sc.nextInt();
        if (menuNum3 == 1) {
            text.orderMenu(order.getSeq());
            order.reset();
            this.matrixTime(3000);
        } else if (menuNum3 == 2) {
            text.reverseMenuPan();
        } else if (menuNum3 == 3) {
            order.reset();
            text.cancel();
        } else {
            text.numberMistake();
        }
    }

    //시간지연
    public void matrixTime(int delayTime) {
        long saveTime = System.currentTimeMillis();
        long currTime = 0;

        while (currTime - saveTime < delayTime) {
            currTime = System.currentTimeMillis();
        }
    }

}
