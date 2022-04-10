package cdu.ht;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.logging.*;

public class JULTest {
    //快速入门
    @Test
    public void test() throws Exception {
        //1、获取日志记录器
        Logger logger = Logger.getLogger("cdu.ht.JULTest");
        //2、日志记录输出
        logger.info("hello jul");

        //通用方法进行日志记录
        logger.log(Level.INFO, "info msg");
        //通过占位符 方式输出变量名

        String name = "你所期望的永远";
        int age = 13;
        logger.log(Level.INFO, "用户信息:{0},{1}", new Object[]{name, age});
    }

    //日志级别
    @Test
    public void test1() throws Exception {
        //1、获取日志记录器
        Logger logger = Logger.getLogger("cdu.ht.JULTest");
        //2、日志记录输出
        logger.info("hello info");
        logger.fine("hello fine");
        logger.severe("hello severe");
        logger.warning("hello warning");
        logger.config("hello config");
        logger.finer("hello finer");
        logger.finest("hello finest");
    }

    //自定义日志级别
    @Test
    public void test2() throws Exception {
        //1、获取日志记录器
        Logger logger = Logger.getLogger("cdu.ht.JULTest");
        //2、自定义配置日志级别
        //关闭系统默认配置
        logger.setUseParentHandlers(false);
        //创建consoleHandler
        ConsoleHandler consoleHandler = new ConsoleHandler();
        //创建简单格式转换对象
        SimpleFormatter formatter = new SimpleFormatter();
        //日志记录输出
        //进行关联
        consoleHandler.setFormatter(formatter);
        logger.addHandler(consoleHandler);
        //设置日志级别
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        FileHandler fileHandler = new FileHandler();
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);
        fileHandler.setLevel(Level.ALL);

        logger.info("hello info");
        logger.severe("hello severe");
        logger.warning("hello warning");
        logger.config("hello config");
        logger.fine("hello fine");
        logger.finer("hello finer");
        logger.finest("hello finest");
    }

    //父类logger
    @Test
    public void test3() throws Exception {
        Logger logger = Logger.getLogger("cdu.ht.cdu.ht.JULTest");
        Logger parent = Logger.getLogger("cdu.ht");
        ConsoleHandler consoleHandler = new ConsoleHandler();
        File file = new File(JULTest.class.getClassLoader().getResource("./logs/jul.log").getPath());
        FileHandler fileHandler = new FileHandler(file.getPath());
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        consoleHandler.setFormatter(simpleFormatter);
        fileHandler.setFormatter(simpleFormatter);
        parent.addHandler(consoleHandler);
        parent.addHandler(fileHandler);
        consoleHandler.setLevel(Level.ALL);
        fileHandler.setLevel(Level.ALL);
        parent.setLevel(Level.ALL);


        logger.setUseParentHandlers(false);
        logger.setLevel(Level.INFO);
        logger.addHandler(consoleHandler);


//        logger.info("hello info");
//        logger.severe("hello severe");
//        logger.warning("hello warning");
//        logger.config("hello config");
//        logger.fine("hello fine");
//        logger.finer("hello finer");
//        logger.finest("hello finest");

        parent.info("hello info");
        parent.severe("hello severe");
        parent.warning("hello warning");
        parent.config("hello config");
        parent.fine("hello fine");
        parent.finer("hello finer");
        parent.finest("hello finest");
    }

    //加载自定义配置文件
    @Test
    public void test4() throws Exception {
        //读取配置文件
        InputStream ins = JULTest.class.getClassLoader().getResourceAsStream("cdu/ht/logging.properties");
        //创建logManager
        LogManager logManager = LogManager.getLogManager();
        logManager.readConfiguration(ins);
        //通过LogManager加载配置问价
        Logger logger = Logger.getLogger("cdu.ht.cdu.ht.JULTest");

        logger.info("hello info");
        logger.severe("hello severe");
        logger.warning("hello warning");
        logger.config("hello config");
        logger.fine("hello fine");
        logger.finer("hello finer");
        logger.finest("hello finest");
    }
    //日志原理解析
    @Test
    public void test6() throws Exception {
        //通过LogManager加载配置问价
        Logger logger = Logger.getLogger("cdu.ht.cdu.ht.JULTest");

        logger.info("hello info");
        logger.severe("hello severe");
        logger.warning("hello warning");
        logger.config("hello config");
        logger.fine("hello fine");
        logger.finer("hello finer");
        logger.finest("hello finest");
    }

    //复制文件操作
    @Test
    public void test5() throws Exception {
        String path = JULTest.class.getClassLoader().getResource("./logs").getPath();
        File file = new File(path + "/java0.log");
        InputStream jul = JULTest.class.getClassLoader().getResourceAsStream("./log4j.properties");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bytes = new byte[512];
        int i = 0;
        while ((i = jul.read(bytes, 0, bytes.length)) != -1) {
            System.out.println(new String(bytes));
        }
    }
}
