package com.nineodes.demo.provider;

import com.nineodes.demo.anotation.RpcService;
import com.nineodes.demo.api.UserService;
import com.nineodes.demo.entity.User;
import org.springframework.stereotype.Service;

@RpcService(name = "com.nineodes.rpcfx.demo.api.UserService", port = 9013)
@Service("com.nineodes.rpcfx.demo.api.UserService")
public class UserServiceImpl implements UserService {

    @Override
    public User findById(int id) {
        return new User(id, "KK" + System.currentTimeMillis());
    }
}
