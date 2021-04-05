package io.nineodes.redis;

import org.redisson.api.listener.MessageListener;

/**
 * @author: 9odes
 * @version: V1.0.0.0
 * @date: 2021-04-02 17:12
 */
public class OrderMessageListen implements MessageListener<String> {
    @Override
    public void onMessage(CharSequence channel, String msg) {
        System.out.println("正在处理->" + msg);
    }
}
