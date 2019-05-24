package com.su.util;

/**
 * @Author: supengfei
 * @Date: 2019/1/21 11:52
 * @Description:
 */
public interface StatusUtil {
    /**
     * @Description //TODO 状态:/1启动 可用
     **/
    Integer ENABLE = 1;
    /**
     * @Description //TODO 0未启动false 不可用
     **/
    Integer DISABLE = 0;
    /**
     * @Description //TODO 1 已到达
     **/
    Integer ISCOME = 1;
    /**
     * @Description //TODO 0 未到店
     * @Param
     * @return
     **/
    Integer NOCOME = 0;

}
