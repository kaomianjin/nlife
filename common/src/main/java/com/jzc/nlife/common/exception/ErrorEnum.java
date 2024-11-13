package com.jzc.nlife.common.exception;


/**
 * @author : hts
 * @Date: 2020/11/3 15:14
 * @Description:
 */
public enum ErrorEnum implements ErrorCode {

    //全局
    OK("ES000200", "正常"),
    INVALID_ARGUMENT("ES000400", "无效的参数"),
    FAILED_PRECONDITION("ES000400", "当前参数逻辑有误"),
    HTTP_ERROR("ES000400", "HTTP调用失败"),
    OUT_OF_RANGE("ES000401", "无效的token信息"),
    PERMISSION_DENIED("ES000403", "token权限不足"),
    NOT_FOUND("ES000404", "找不到指定的资源"),
    HTTP_NOT_SUPPORT("ES000405", "服务器不支持请求行中的method方法"),
    HTTP_TIME_OUT("ES000408", "服务器接收请求超时"),
    ALREADY_EXISTS("ES000409", "资源已存在"),
    CANCELLED("ES000499", "客户端取消请求"),
    DATA_LOSS("ES000500", "不可恢复的数据丢失"),
    UNKNOWN("ES000500", "未知的服务器错误"),
    MULTIPART("ES000501", "上传文件过大,文件大小不得超过10M"),


    NOT_FOUND_CLUSTER("ES_NOT_FOUND_CLUSTER", "未找到集群"),

    NOT_OPERATE_CLUSTER("ES_NOT_OPERATE_CLUSTER", "集群当前不可操作"),

    RESTART_FAILED("ES_RESTART_FAILED", "重启指令发送失败"),

    UPGRADE_FAILED("ES_UPGRADE_FAILED", "升级指令发送失败"),

    INVALID_PARAMETER("ES_INVALID_PARAMETER", "参数解析错误"),

    CREATE_FAILED("CREATE_FAILED", "创建集群失败"),

    UPDATE_FAILED("UPDATE_FAILED", "变更集群失败"),

    UNSUBSCRIBE_FAILED("UNSUBSCRIBE_FAILED", "退订集群失败");


    //业务异常 另建枚举

    private String code;

    private String message;

    ErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
