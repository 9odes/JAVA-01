package com.nineodes.demo.api;

import com.nineodes.demo.entity.Order;

public interface OrderService {

    Order findOrderById(int id);

}
