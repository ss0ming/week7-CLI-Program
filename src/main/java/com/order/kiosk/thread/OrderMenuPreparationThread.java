package com.order.kiosk.thread;

public class OrderMenuPreparationThread extends Thread {

    private int cookingTime;
    private MenuReadyNotificationThread notificationThread;

    public OrderMenuPreparationThread(int cookingTime, MenuReadyNotificationThread notificationThread) {
        this.cookingTime = cookingTime;
        this.notificationThread = notificationThread;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(cookingTime * 1000);
            notificationThread.setReady();
            System.out.println("\n\n주문하신 메뉴가 나왔습니다. 맛있게 드세요!");
        } catch (InterruptedException e) {
            System.out.println("주문 준비 중 인터럽트 발생!!");
        }
    }
}
