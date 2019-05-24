package com.su.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.su.dao.RegisterInfoMapper;
import com.su.entity.RegisterInfoEntity;
import com.su.service.IRegisterInfoService;
import org.springframework.stereotype.Service;

/**
 * @Author: supengfei
 * @Date: 2019/5/20 22:34
 * @Description:
 */
@Service
public class RegisterInfoServiceImpl extends ServiceImpl<RegisterInfoMapper, RegisterInfoEntity> implements IRegisterInfoService {
}
