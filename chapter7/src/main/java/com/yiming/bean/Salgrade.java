package com.yiming.bean;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author YiMing
 * @since 2022-02-12
 */
public class Salgrade implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal grade;

    private BigDecimal losal;

    private BigDecimal hisal;


    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public BigDecimal getLosal() {
        return losal;
    }

    public void setLosal(BigDecimal losal) {
        this.losal = losal;
    }

    public BigDecimal getHisal() {
        return hisal;
    }

    public void setHisal(BigDecimal hisal) {
        this.hisal = hisal;
    }

    @Override
    public String toString() {
        return "Salgrade{" +
        "grade=" + grade +
        ", losal=" + losal +
        ", hisal=" + hisal +
        "}";
    }
}
