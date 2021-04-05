package io.nineodes.redis;

import io.netty.util.CharsetUtil;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

/**
 * @author: 9odes
 * @version: V1.0.0.0
 * @date: 2021-04-02 17:08
 */
public class ListenRunnable implements Runnable {

    private static RedissonClient client;

    static {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        client = Redisson.create(config);
    }

    @Override
    public void run() {
        System.out.println(System.currentTimeMillis() + " - 启动监听");
        System.out.println(client.getTopic("local").getChannelNames());
        //简单推送
//        System.out.println(client.getTopic("local", new StringCodec(CharsetUtil.UTF_8)).publish("ABC"));
        //这个输出需要加解释器否则输入文字不展示
        client.getTopic("local", new StringCodec(CharsetUtil.UTF_8)).addListener(String.class, new OrderMessageListen());
        System.out.println(System.currentTimeMillis() + " - 完成监听");
    }


}
