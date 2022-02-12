package com.yiming.service.impl;

import com.yiming.bean.Emp;
import com.yiming.mapper.EmpMapper;
import com.yiming.service.EmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author YiMing
 * @since 2022-02-12
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {

}
