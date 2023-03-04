DELIMITER $$

CREATE PROCEDURE p_register_payment (
    IN workerId INT
   ,IN paymentDate DATE
   ,IN boost INT
   ,OUT success BOOLEAN
   ,OUT paymentId BIGINT
   ,OUT errMsg VARCHAR(25)
)
root: BEGIN
    DECLARE age INT;
    DECLARE paymentAmount BIGINT;
    DECLARE payId BIGINT;

    SET success = FALSE;
    SET age = null;

    SELECT TIMESTAMPDIFF(YEAR, birth, paymentDate ) INTO age
    FROM m_worker
    WHERE person_id = workerId
        AND LgcDelFlg = FALSE;

    IF age is null THEN
        SET paymentId = null;
        SET errMsg = 'that worker is not exists';
        LEAVE root;
    END IF;

    SELECT amount INTO paymentAmount
    FROM m_salary
    WHERE pay_rank_id = age;

    IF paymentAmount is null THEN
        SET paymentId = null;
        SET errMsg = 'salary data not found';
        LEAVE root;
    END IF;

    SET paymentAmount = paymentAmount * (boost / 100);

    START TRANSACTION;

    SET payId = UUID_SHORT();

    INSERT INTO t_payment (
        person_id, payment_id, payed_date, amount, note
    ) VALUES (
        workerId, payId, paymentDate, paymentAmount, null
    );

    COMMIT;

    SET success = TRUE;
    SET paymentId = payId;
    SET errMsg = null;
END$$ --root
DELIMITER ;