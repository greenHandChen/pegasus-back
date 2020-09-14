package com.pegasus;

import com.pegasus.common.rocketmq.autoconfigure.EnableCuxRocketMQ;
import com.pegasus.common.utils.ApplicationContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by enHui.Chen on 2019/8/8.
 */
@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
@EnableCuxRocketMQ
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
