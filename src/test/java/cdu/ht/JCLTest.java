package cdu.ht;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class JCLTest {
    @Test
    public void test(){
        //获取log 日志记录器
        Log log = LogFactory.getLog(JCLTest.class);
        //日志记录的输出
        log.info("hello JCL");
        log.fatal("fatal");
        log.error("error");
        log.warn("warn");
        log.info("info");
        log.debug("debug");
    }
}
