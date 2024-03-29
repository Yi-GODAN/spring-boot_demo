package com.yiming.controller;


import com.yiming.base.result.ResultWrapper;
import com.yiming.bean.CouponSyncValidVO;
import com.yiming.service.CouponSyncValidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author YiMing
 * @since 2022-02-11
 */
@Slf4j
@RestController
@RequestMapping("/couponSyncValid")
public class CouponSyncValidController {
    
    @Resource
    private CouponSyncValidService distributeSyncService;

    @PostMapping("/updateCouponBatchId")
    public ResultWrapper updateCouponBatchId(@RequestBody List<CouponSyncValidVO> syncValidVO) {

        log.info("CouponSyncValidController updateCouponBatchId syncValidVO = {}", syncValidVO);

        distributeSyncService.mergeCouponBatchId(syncValidVO);

        ResultWrapper result = ResultWrapper.getSuccessBuilder().build();

        log.info("CouponSyncValidController updateCouponBatchId result = {}", result);

        return result;
    }

}

