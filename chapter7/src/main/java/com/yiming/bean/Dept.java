package com.yiming.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author YiMing
 * @since 2022-02-12
 */
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "DEPTNO", type = IdType.AUTO)
    private Integer deptno;

    private String dname;

    private String loc;


    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Dept{" +
        "deptno=" + deptno +
        ", dname=" + dname +
        ", loc=" + loc +
        "}";
    }
}
