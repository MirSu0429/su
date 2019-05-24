package com.su.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.su.dao.JobEntityMapper;
import com.su.entity.JobEntity;
import com.su.service.IJobEntityService;
import com.su.util.ServiceUtil;
import com.su.util.StatusUtil;
import com.su.util.quertz.JobTaskUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: supengfei
 * @Date: 2019/1/21 10:49
 * @Description:
 */
@Service("jobEntityService")
public class JobEntityServiceImpl extends ServiceImpl<JobEntityMapper, JobEntity> implements IJobEntityService {
    @Autowired
    private ServiceUtil<JobEntity> serviceUtil;

    @Autowired
    private JobTaskUtil jobTaskUtil;

  /*  @Autowired
    private RedisUtil redisUtil;*/

    @Override
    public Integer insertJob(JobEntity job) {
        try {
            job = serviceUtil.addValue(job, true);
        }catch (Exception e){
        }
        Integer insert = baseMapper.insert(job);
        //删除结果集缓存
       // redisUtil.del("selectListJob");
        return insert;
    }

    @Override
    public Integer startJob(String id) {
        JobEntity job = baseMapper.selectById(id);
        jobTaskUtil.startJob(job);
        job.setStatus(StatusUtil.ENABLE);
        Integer integer = baseMapper.updateById(job);
        //删除结果集缓存
        //redisUtil.del("selectListJob");
        return integer;
    }

    @Override
    public Integer pauseJob(String id) {
        JobEntity job = baseMapper.selectById(id);
        jobTaskUtil.remove(job);
        job.setStatus(StatusUtil.DISABLE);
        Integer integer = baseMapper.updateById(job);
        //删除结果集缓存
       // redisUtil.del("selectListJob");
        return integer;
    }

    @Override
    public List<JobEntity> selectListJob() {
       /* List<Object> redisList = redisUtil.lGet("selectListJob", 0, -1);
        if (redisList != null && redisList.size() > 0) {
            return (List<JobEntity>) redisList.get(0);
        } else {
            List<JobEntity> jobEntityList = baseMapper.selectList(null);
            redisUtil.lSet("selectListJob", jobEntityList);
            return jobEntityList;
        }*/
        return baseMapper.selectList(null);
    }


}
