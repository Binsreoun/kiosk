package main.java;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Title> foodList = new ArrayList<>();
        Order order = new Order();
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

        boolean end = false;
        System.out.println("HAMPICHIPARI에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        while (end == false) {
            System.out.println("[ Food MENU ]");
            foodList.get(0).orderMenu();
            foodList.get(1).orderMenu();
            foodList.get(2).orderMenu();
            foodList.get(3).orderMenu();
            foodList.get(4).orderMenu();
            foodList.get(5).orderMenu();
            System.out.println();
            System.out.println("[ ORDER  MENU ]");
            System.out.printf("%-2s %-10s %1s", Title.numder, "Order", "장바구니를 확인 후 주문합니다.\n");
            System.out.printf("%-2s %-10s %1s", Title.numder + 1, "Cancel", "진행중인 주문을 취소합니다.\n");
            System.out.println();
            System.out.println("번호를 입력해주세요!");

            int orderNum = sc.nextInt();
            if (orderNum < Title.numder) {
                foodList.get(orderNum - 1).foodMenu();
                System.out.println();

                int menuNum = sc.nextInt();
                foodList.get(orderNum - 1).foodPikMenu(menuNum - 1);
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까??");
                System.out.println("1 확인 \t\t\t 2 취소");

                int menuNum2 = sc.nextInt();
                if (menuNum2 == 1) {
                    order.setOrderList(foodList.get(orderNum - 1).getMenus(menuNum - 1));
                    System.out.println("장바구니에 추가되었습니다!");
                    System.out.println();
                    Thread.sleep(1000);
                } else if (menuNum2 == 2) {
                    System.out.println("취소되었습니다!");
                    System.out.println();
                    Thread.sleep(1000);
                } else {
                    System.out.println("번호를 잘못입력했습니다.");
                    System.out.println();
                    Thread.sleep(1000);
                }

            } else if (orderNum == Title.numder) {
                order.getOrderList();
                System.out.println();
                System.out.println("주문하시겠습니까??");
                System.out.println("1 주문 \t\t\t 2 취소");
                int menuNum3 = sc.nextInt();
                if (menuNum3 == 1) {
                    System.out.println("주문이 완료되었습니다.");
                    System.out.println();
                    Thread.sleep(1000);
                    end = true;
                } else if (menuNum3 == 2) {
                    System.out.println("취소되었습니다!");
                    System.out.println();
                    Thread.sleep(1000);
                } else {
                    System.out.println("번호를 잘못입력했습니다.");
                    System.out.println();
                    Thread.sleep(1000);
                }
            } else if (orderNum == Title.numder + 1) {
                end = true;
            } else {
                System.out.println("번호를 잘못입력했습니다.");
                System.out.println();
                Thread.sleep(1000);
            }
        }
    }
}