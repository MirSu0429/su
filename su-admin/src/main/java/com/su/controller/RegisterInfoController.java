package com.su.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.su.entity.RegisterInfoEntity;
import com.su.exception.MyException;
import com.su.service.IRegisterInfoService;
import com.su.util.ResponseUtil;
import com.su.util.StatusUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author: supengfei
 * @Date: 2019/5/20 22:36
 * @Description:
 */
@RestController
@RequestMapping("/registerInfo")
public class RegisterInfoController {
    public static final Logger loger = LoggerFactory.getLogger(RegisterInfoController.class);
    @Autowired
    private IRegisterInfoService iRegisterInfoService;

    @PostMapping(value = "/submitDate")
    public ResponseUtil addRegisterInfo(@RequestBody RegisterInfoEntity registerInfoEntity) {
        loger.info("前台传入参数:registerInfoEntity--->" + registerInfoEntity.toString());
        if (registerInfoEntity == null) {
            throw new MyException("前台传参异常!");
        }
        registerInfoEntity.setIsCome(StatusUtil.NOCOME);
        registerInfoEntity.setCreateTime(new Date());
        registerInfoEntity.setStatus(StatusUtil.ENABLE);
        loger.info("开始新增.参数为:registerInfoEntity--->" + registerInfoEntity.toString());
        iRegisterInfoService.insert(registerInfoEntity);
        return ResponseUtil.sucess("新增成功!");
    }

    @GetMapping(value = "/editRegister")
    public ResponseUtil editRegister(@RequestParam("id") Integer id) {
        loger.info("前台传入参数:id--->" + id);
        if (id == null || id == 0) {
            throw new MyException("前台传参异常!");
        }
        RegisterInfoEntity registerInfoEntity = new RegisterInfoEntity();
        registerInfoEntity.setId(id);
        registerInfoEntity.setIsCome(StatusUtil.ISCOME);
        registerInfoEntity.setComeTime(new Date());
        loger.info("开始修改.参数为:registerInfoEntity--->" + registerInfoEntity.toString());
        iRegisterInfoService.updateById(registerInfoEntity);
        return ResponseUtil.sucess("修改成功!");
    }

    @GetMapping("/queryAllRegister")
    private List<RegisterInfoEntity> queryAllRegister(@RequestParam("key") String key) {
        loger.info("开始查询.传入参数为:--->key:->" + key);
        Wrapper<RegisterInfoEntity> wrapper = new EntityWrapper<>();
        if (key != null) {
            wrapper.like("name", key).or().like("tel", key).or().like("car_number", key);
        }
        List<RegisterInfoEntity> selectList = iRegisterInfoService.selectList(wrapper);
        loger.info("查询结果为:selectList--->" + selectList.toString());
        return selectList;
    }

    @GetMapping("/app/queryAllRegister")
    private List<RegisterInfoEntity> queryAppAllRegister() {
        loger.info("开始查询.传入参数为:--->null");
        Wrapper<RegisterInfoEntity> wrapper = new EntityWrapper<>();
        wrapper.orderBy("is_come", false).orderBy("create_time", false);
        Page<RegisterInfoEntity> selectPage = iRegisterInfoService.selectPage(new Page<RegisterInfoEntity>(1, 20), wrapper);
        List<RegisterInfoEntity> selectList = selectPage.getRecords();
        loger.info("查询结果为:selectList--->" + selectList.toString());
        for (RegisterInfoEntity infoEntity : selectList) {
            infoEntity.setCarNumber(infoEntity.getCarNumber().substring(0, 3) + "**" + infoEntity.getCarNumber().substring(5));
        }
        loger.info("处理车牌信息后:selectList--->" + selectList.toString());
        return selectList;
    }

    @GetMapping("/getCounts")
    public Integer getCounts() {
        return iRegisterInfoService.selectCount(null);
    }

    @GetMapping("/getComeCounts")
    public Integer getComeCounts() {
        Wrapper<RegisterInfoEntity> eq = new EntityWrapper<RegisterInfoEntity>().eq("is_come", StatusUtil.ISCOME);
        return iRegisterInfoService.selectCount(eq);
    }
}
