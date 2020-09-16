package com.pegasus;

import com.pegasus.common.rocketmq.autoconfigure.EnablePegasusRocketMQ;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by enHui.Chen on 2019/8/8.
 */
@EnablePegasusRocketMQ
@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
public class PegasusApplication {
    public static void main(String[] args) {
        setSystemProperty();
        SpringApplication.run(PegasusApplication.class);
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String hashPassword = passwordEncoder.encode("localhost");
//        return hashPassword;
    }


    private static void setSystemProperty() {
        System.setProperty("rocketmq.client.logRoot", "logs/rocketmq");
    }
}
