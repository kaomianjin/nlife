package com.jzc.nlife.common.entity.normal;

import com.jzc.nlife.common.exception.ErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

//@Data
//@Slf4j
@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@ApiModel(value = "统一数据返回对象", description = "所有数据经此包装")
public class R<T> implements Serializable {

    public static final String REQUEST_STATUS_ERROR = "error";
    public static final String REQUEST_STATUS_SUCCESS = "success";
    private static final long serialVersionUID = 1L;
    /**
     * 状态码
     */
//    @ApiModelProperty(required = true, value = "返回状态码", dataType = "String", example = "200", position = 0)
    private String code;
    /**
     * 返回数据
     */
//    @ApiModelProperty(required = true, value = "返回数据", dataType = "string", example = "{'version': '3.0.5'}", position = 1)
    private T data;
    /**
     * msg信息
     */
//    @ApiModelProperty(required = true, value = "返回message 信息", dataType = "string", example = "success", position = 2)
    private String message;
    /**
     * ok or error
     */
//    @ApiModelProperty(required = true, value = "返回接口调用成功or失败信息", dataType = "string", example = "ok", position = 3)
    private String status;

    public static R result(boolean flag) {
        if (flag) {
            return okResult();
        }
        return failResult();
    }

    /**
     * 成功操作 操作码默认为200   无参
     *
     * @return
     */
    public static R okResult() {
        return okResult("");
    }

    /**
     * 成功操作 设置数据
     **/
    public static <T> R<T> okResult(T data) {
        return okResult(ErrorEnum.OK.getCode(), data);
    }

    /**
     * 成功操作 设置返回码及数据
     **/
    public static <T> R<T> okResult(String code, T data) {
        return okResult(code, REQUEST_STATUS_SUCCESS, data);
    }


    /**
     * 成功操作 设置返回码及数据及message信息
     **/
    public static <T> R<T> okResult(String code, String msg, T data) {

        return R.<T>builder()
                .data(data)
                .code(code)
                .message(msg)
                .status(REQUEST_STATUS_SUCCESS)
                .build();
    }

    /**
     * 失败返回 无参
     *
     * @return
     */
    public static R failResult() {
        return failMsgResult("");
    }

    /**
     * 失败返回 设置失败码
     **/
    public static R failCodeResult(String code) {
        return failResult(code, REQUEST_STATUS_ERROR);
    }

    /**
     * 失败返回 设置msg
     **/
    public static R failMsgResult(String msg) {
        return failResult(ErrorEnum.UNKNOWN.getCode(), msg);
    }

    /**
     * 参数校验失败返回 设置返回码及msg
     **/
    public static R checkResult(String msg) {
        return failResult(ErrorEnum.HTTP_ERROR.getCode(), msg, "");
    }

    /**
     * 失败返回 设置返回码及msg
     **/
    public static R failResult(String code, String msg) {
        return failResult(code, msg, "");
    }

    /**
     * 失败返回 设置返回码及数据及message信息
     **/
    public static <T> R<T> failResult(String code, String msg, T data) {
        return R.<T>builder()
                .data(data)
                .code(code)
                .message(msg)
                .status(REQUEST_STATUS_ERROR)
                .build();
    }

    public boolean success() {

        return REQUEST_STATUS_SUCCESS.equals(status);
    }
}