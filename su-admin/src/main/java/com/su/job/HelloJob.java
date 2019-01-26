package com.su.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class HelloJob implements BaseJob {  
  
    private static Logger _log = LoggerFactory.getLogger(HelloJob.class);  
     
    public HelloJob() {  
          
    }  
     
    @Override
    public void execute(JobExecutionContext context)
        throws JobExecutionException {  
        _log.info("Hello Job执行时间: " + new Date());
    }
}  