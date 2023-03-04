package pro.eng.yui.samples.callProcWithMybatis;

/**
 * Sample Project
 * for engineer who using Mybatis and MySql,
 * and want to call Stored Procedure
 * @author KITAMURA Yui
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("-------->");
        System.out.println("Start Main");

        System.out.println("End Main");
        System.out.println("--------<");
    }
}

/* package-private */ interface QueryId{
    String namespace = "pro.eng.yui.samples.";
    String ns_p = namespace + "p_register_payment.";
    String run = ns_p + "run";
}