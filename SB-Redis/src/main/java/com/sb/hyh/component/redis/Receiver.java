package com.sb.hyh.component.redis;

import java.util.concurrent.CountDownLatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

// 发布订阅是一种典型的异步通信模型，可以让消息的发布者和订阅者充分解耦。
// 使用StringRedisTemplate来发布一个字符串消息，同时基于MessageListenerAdapter使用一个POJO来订阅和响应该消息。

// Spring Data Redis提供基于Redis发送和接收消息的所有需要的组件：
// 一个连接工厂（connection factory）
// 一个消息监听者容器(message listener container)
// 一个Redis的模板(redis template)

// 通过Redis模板来发送消息，同时将Receiver注册给消息监听者容器。
// 连接工厂将两者连接起来，使得它们可以通过Redis服务器通信,我们将连接工厂实例分别注入到监听者容器和Redis模板中。

/**
 * 消息接收者
 */
public class Receiver {
    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);
    private CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(String message) {
        logger.info("Received <" + message + ">");
        latch.countDown();
    }
}