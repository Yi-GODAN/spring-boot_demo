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
public class Bonus implements Serializable {

    private static final long serialVersionUID = 1L;

    private String ename;

    private String job;

    private BigDecimal sal;

    private BigDecimal comm;


    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    public BigDecimal getComm() {
        return comm;
    }

    public void setComm(BigDecimal comm) {
        this.comm = comm;
    }

    @Override
    public String toString() {
        return "Bonus{" +
        "ename=" + ename +
        ", job=" + job +
        ", sal=" + sal +
        ", comm=" + comm +
        "}";
    }
}
