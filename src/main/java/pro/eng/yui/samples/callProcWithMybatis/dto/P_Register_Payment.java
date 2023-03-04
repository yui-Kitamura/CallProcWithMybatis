package pro.eng.yui.samples.callProcWithMybatis.dto;

import pro.eng.yui.samples.callProcWithMybatis.dto.colType.ErrMsg;

/**
 * Data Transfer Object class
 * for procedure <code>p_register_payment</code>
 */
public class P_Register_Payment {
    /* *** inputs *** */
    public Integer workerId;
    public java.sql.Date paymentDate;
    public Integer boost;

    /* *** outputs *** */
    public Boolean success;
    public Integer paymentId;
    public ErrMsg errMsg;
}
