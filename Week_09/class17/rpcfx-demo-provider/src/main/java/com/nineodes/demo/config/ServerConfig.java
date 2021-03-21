package com.nineodes.demo.config;

import com.nineodes.api.RpcfxResolver;
import com.nineodes.server.RpcfxInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * created by DengJin on 2021/3/16 17:41
 */
@Configuration
public class ServerConfig {
    @Bean
    public RpcfxInvoker createInvoker(@Autowired RpcfxResolver resolver){
        return new RpcfxInvoker(resolver);
    }

    @Bean
    public RpcfxResolver createResolver(){
        return new DemoResolver();
    }
}
