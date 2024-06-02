package com.order.customer;

import com.order.menu.MainDish;
import com.order.menu.Menu;
import com.order.view.OutputView;

import java.util.Map;
import java.util.Optional;

public class Cart {

    private final Map<Menu, Integer> orders;

    public Cart(Map<Menu, Integer> orders) {
        this.orders = orders;
    }

    public void showOrders() {
        OutputView.printOrders(orders);
    }

    public int calculateCookingTime() {
        Optional<Integer> maxCookingTime = orders.keySet().stream()
                .filter(menu -> "MainDish".equals(menu.getCategory()))
                .map(menu -> ((MainDish)menu).calculateCookingTime())
                .max(Integer::compare);

        return maxCookingTime.orElse(2);
    }

}
