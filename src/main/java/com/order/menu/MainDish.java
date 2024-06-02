package com.order.menu;

public abstract class MainDish extends Menu {

    public MainDish(String name, int price) {
        super(name, price, "MainDish");
    }

    public abstract int calculateCookingTime();
}
