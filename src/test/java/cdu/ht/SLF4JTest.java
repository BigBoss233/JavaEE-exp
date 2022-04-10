package cdu.ht;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.apache.logging.log4j.Logger;


public class SLF4JTest {
    //快速入门
    public static final Logger logger = LogManager.getLogger(SLF4JTest.class);

    @Test
    public void test() {
       // for (int i = 0; i < 10000; i++) {
            logger.fatal("hello fatal");
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
