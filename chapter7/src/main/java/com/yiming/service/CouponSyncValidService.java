package com.yiming.service;

import com.yiming.bean.CouponSyncValidVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author YiMing
 * @since 2022-02-11
 */
public interface CouponSyncValidService extends IService<CouponSyncValidVO> {

    void mergeCouponBatchId(List<CouponSyncValidVO> syncValidVO);

}