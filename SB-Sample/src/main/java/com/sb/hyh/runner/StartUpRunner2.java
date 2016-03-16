package com.sb.hyh.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 服务启动执行
 */
@Component
@Order(value = 1)
public class StartUpRunner2 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("StartUpRunner2服务启动执行,执行加载数据等操作");
    }
}