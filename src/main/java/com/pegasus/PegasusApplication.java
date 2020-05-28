package com.pegasus;

import com.pegasus.common.rocketmq.autoconfigure.EnableCuxRocketMQ;
import com.pegasus.common.utils.HttpUtil;
import com.pegasus.common.utils.RsaUtil;
import com.pegasus.test.httpproxy.HttpUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Created by enHui.Chen on 2019/8/8.
 */
@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
@EnableCuxRocketMQ
public class PegasusApplication {
    public static void main(String[] args) throws Exception {
        StringBuilder s = new StringBuilder("dssddsds-dsd-dsds222-dsds1111");

        System.out.println(s.replace(s.lastIndexOf("-"),s.lastIndexOf("-")+1,"."));
//        LocalDate minus = LocalDate.now().minus(1, ChronoUnit.DAYS);
//        System.out.println(DateTimeFormatter.ofPattern("yyyy/MM/dd").format(minus));
//        PegasusApplication.setSystemProperty();
//        SpringApplication.run(PegasusApplication.class);
//        String publicKey = RsaUtil.encryptByPublicKey(String.valueOf(System.currentTimeMillis()), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCbKpe4efW5lgFNfTKAjZheDk3/uvfF/4OVm9qNGmlS+DRLb1nOp7RCjDre3MZeyz4+Moc6nqrCBWsqZtGdq/+u5N8kJclQ3MvyM6RrqWsSdV+8IfCKi8DOPS4D23puGl3T2Hde+iHcjD7FbqZl5EB4tatOWYO5HvrOF9AnFAI7IwIDAQAB");
//        System.out.printf(publicKey);
//        byte[] bytes = HttpUtil.downloadFileByte("");
//        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D:\\aa.xlsx"));
//        bufferedOutputStream.write(bytes);
//        bufferedOutputStream.close();
    }

    private static void setSystemProperty() {
        System.setProperty("rocketmq.client.logRoot", "logs/rocketmq");
    }
}
