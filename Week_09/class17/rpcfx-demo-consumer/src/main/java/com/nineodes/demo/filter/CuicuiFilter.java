package com.nineodes.demo.filter;

import com.nineodes.api.Filter;
import com.nineodes.api.RpcfxRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * created by DengJin on 2021/3/17 18:07
 */
@Slf4j
@Component
public class CuicuiFilter implements Filter {
    @Override
    public boolean filter(RpcfxRequest request) {
        log.info("filter {} -> {}", this.getClass().getName(), request.toString());
        return true;
    }
}
