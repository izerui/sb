package com.sb.hyh.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 服务启动执行
 */
@Component
@Order(value = 2)
public class StartUpRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("StartUpRunner服务启动执行,执行加载数据等操作");
    }
}