package com.yiming.service.impl;

import com.yiming.bean.CouponSyncValidVO;
import com.yiming.mapper.CouponSyncValidMapper;
import com.yiming.service.CouponSyncValidService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author YiMing
 * @since 2022-02-11
 */
@Service
public class CouponSyncValidServiceImpl extends ServiceImpl<CouponSyncValidMapper, CouponSyncValidVO> implements CouponSyncValidService {

    @Resource
    private CouponSyncValidMapper syncValidMapper;

    @Override
    public void mergeCouponBatchId(List<CouponSyncValidVO> syncValidVO) {

        syncValidMapper.mergeCouponBatchId(syncValidVO);

    }

}
