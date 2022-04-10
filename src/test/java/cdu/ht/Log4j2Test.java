package cdu.ht;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4j2Test {
    //快速入门
    public static final Logger logger = LoggerFactory.getLogger(Log4j2Test.class);

    @Test
    public void test() {
       // for (int i = 0; i < 10000; i++) {
            logger.error("hello error");
            logger.warn("hello warn");
            logger.info("hello info");
            logger.debug("hello debug");
            logger.trace("hello trace");

            String name = "你所期望的永远";
            Integer age = 14;
            logger.info("用户:{},{}", name, age);
            try {
                int j = 1 / 0;
            } catch (Exception e) {
                logger.error("出现异常{}", e.getLocalizedMessage());
            }
       // }
    }
    // 桥接
    @Test
    public void test1() {

    }
}
