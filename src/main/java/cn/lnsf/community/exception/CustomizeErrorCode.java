package cn.lnsf.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001,"问题不存在或已被删除！"),
    TARGET_PARAM_FOUND(2002,"未选中任何问题或评论进行回复"),
    NO_LOGIN(2003,"未登录，请先登录再评论"),
    SYS_ERROR(2004,"服务器异常！"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006,"评论不存在"),
    CONTENT_IS_EMPTY(2007,"输入内容不能为空"),
    ;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
