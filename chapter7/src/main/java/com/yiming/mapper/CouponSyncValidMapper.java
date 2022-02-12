package com.yiming.mapper;

import com.yiming.bean.CouponSyncValidVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author YiMing
 * @since 2022-02-11
 */
@Mapper
public interface CouponSyncValidMapper extends BaseMapper<CouponSyncValidVO> {

    void mergeCouponBatchId(@Param("list") List<String> list, @Param("status") String status);

}
