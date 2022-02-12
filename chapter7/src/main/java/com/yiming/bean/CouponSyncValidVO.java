package com.yiming.bean;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author YiMing
 * @since 2022-02-11
 */
@Data
public class CouponSyncValidVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * coupon batch id
     */
    private String batchId;

    /**
     * status
     */
    private String status = "00";

    /**
     * Whether to cache
     */
    private boolean isCache = true;

}
