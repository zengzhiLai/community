package cn.lnsf.community.enums;

/**
 * 通知的阅读状态 0 未阅读 ，1 阅读
 *
 * @author ：赖增智
 * @date ：Created in 2019-10-19 20:06
 */
public enum NotificationStatusEnum {
    UNREAD(0),
    READ(1);

    private int status;

    public int getStatus() {
        return status;
    }

    NotificationStatusEnum(int status) {
        this.status = status;
    }
}
