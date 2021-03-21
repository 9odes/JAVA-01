package com.nineodes.demo.controller;

import com.nineodes.api.RpcfxResponse;
import com.nineodes.api.RpcfxRequest;
import com.nineodes.server.RpcfxInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by DengJin on 2021/3/16 17:39
 */
@RestController
public class ServerController {

    @Autowired
    RpcfxInvoker invoker;

    @PostMapping("/")
    public RpcfxResponse invoke(@RequestBody RpcfxRequest request) {
        return invoker.invoke(request);
    }
}
