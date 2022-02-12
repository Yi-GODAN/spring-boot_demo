package com.yiming.bean;

import lombok.Data;

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
     * batchId for list
     */
    private List<String> list;

    /**
     * status
     */
    private String status;

    /**
     * Whether to cache
     */
    private boolean isCache;

}
