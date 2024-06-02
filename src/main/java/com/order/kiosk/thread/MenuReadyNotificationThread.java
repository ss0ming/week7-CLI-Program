package com.order.kiosk.thread;

public class MenuReadyNotificationThread extends Thread{

    private volatile boolean isReady = false;

    public MenuReadyNotificationThread () {
    }

    @Override
    public void run() {
        StringBuilder cooking = new StringBuilder("조리중");
        while (!isReady) {
            System.out.print("\r" + cooking);
            cooking.append(".");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("메뉴 준비 완료 인터럽트 발생!!");
            }
        }
    }

    public void setReady() {
        isReady = true;
    }
}
