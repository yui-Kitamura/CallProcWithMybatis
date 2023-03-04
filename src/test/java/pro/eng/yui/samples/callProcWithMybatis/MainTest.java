package pro.eng.yui.samples.callProcWithMybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pro.eng.yui.samples.callProcWithMybatis.dto.P_Register_Payment;

import java.io.InputStream;
import java.sql.Date;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private static SqlSession session;
    @BeforeAll
    public static void beforeAll(){
        System.out.println("-- setup with DbUnit START ----->");
        try {
            try(InputStream in = MainTest.class.getResourceAsStream("/mybatis/mybatis-config.xml")){
                SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
                Properties prop = new Properties();
                prop.setProperty("mysqlUserName", System.getenv("mysqlUserName"));
                prop.setProperty("mysqlUserPass", System.getenv("mysqlUserPass"));
                session = factoryBuilder.build(in, prop).openSession();
            }
            System.out.println("-- setup with DbUnit END -----<");
        }catch(Exception e){
            System.out.println("** setup with DbUnit ABEND *****<");
            fail(e);
        }
    }

    @Test
    public void test(){
        P_Register_Payment paramAndResult = new P_Register_Payment();
        paramAndResult.workerId = 1234;
        paramAndResult.paymentDate = new Date(2023,2,27);
        paramAndResult.boost = 100;
        session.update(QueryId.run, paramAndResult);

        assertAll(
                () -> {assertTrue(paramAndResult.success);},
                () -> {assertNull(paramAndResult.errMsg);},
                () -> {assertNotNull(paramAndResult.paymentId);}
        );
        System.out.println("paymentId is "+ paramAndResult.paymentId);
    }


    @AfterAll
    public static void afterAll(){
        System.out.println("-- tearDown with DbUnit START ----->");
        try {
            if (session != null){
                session.close();
            }
        }catch(Exception e){
            System.out.println("** tearDown with DbUnit Caused ERROR *****<");
            e.printStackTrace();
        }
        System.out.println("-- tearDown with DbUnit END -----<");
    }

}