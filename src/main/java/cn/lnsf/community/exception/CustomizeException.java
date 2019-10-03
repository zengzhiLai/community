package cn.lnsf.community.exception;

/**
 * @author ：赖增智
 * @date ：Created in 2019-10-3 0:15
 */
public class CustomizeException extends RuntimeException{

    private String message;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }
    public CustomizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
