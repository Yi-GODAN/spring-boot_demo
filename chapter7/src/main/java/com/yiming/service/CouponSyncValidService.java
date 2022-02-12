package com.yiming.service;

import com.yiming.bean.CouponSyncValidVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author YiMing
 * @since 2022-02-11
 */
public interface CouponSyncValidService extends IService<CouponSyncValidVO> {

    void mergeCouponBatchId(CouponSyncValidVO syncValidVO);

}