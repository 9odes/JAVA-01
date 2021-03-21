package com.nineodes.demo.provider;

import com.nineodes.demo.anotation.RpcService;
import com.nineodes.demo.entity.Order;
import com.nineodes.demo.api.OrderService;
import org.springframework.stereotype.Service;

@RpcService(name = "com.nineodes.rpcfx.demo.api.OrderService", port = 9013)
@Service("com.nineodes.rpcfx.demo.api.OrderService")
public class OrderServiceImpl implements OrderService {

    @Override
    public Order findOrderById(int id) {
        return new Order(id, "Cuijing" + System.currentTimeMillis(), 9.9f);
    }
}
