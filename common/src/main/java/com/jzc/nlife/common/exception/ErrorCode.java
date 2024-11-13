package com.jzc.nlife.common.exception;

/**
 * 业务级别的错误码定义 (需要自己补充)
 * 10000-19999  用户类型
 * 11100-11300 ece-api-service  区间 200
 * 11400-11600 mop-api-service  区间 200
 * <p>
 * 20000-29999  系统类型
 * 21100-11300 ece-api-service  区间 200
 * 21400-11600 mop-api-service  区间 200
 * @author : jk
 */
public interface ErrorCode {

    /**
     * 获取错误码
     *
     * @return
     */

    String getCode();

    /**
     * 获取错误信息
     *
     * @return
     */

    String getMessage();
}
