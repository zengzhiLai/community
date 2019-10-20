package cn.lnsf.community.enums;

/**
 * 通知的类型
 * 1 回复问题，2 回复评论
 *
 * @author ：zengzhilai
 * @date ：Created in 2019-10-19 19:57
 */
public enum NotificationTypeEnum {
    REPLY_QUESTION(1, "回复了问题"),
    REPLY_COMMENT(2, "回复了评论");
    private int type;
    private String name;

    /**
     * 返回type对应的名称
     * @param type
     * @return
     */
    public static String nameOfType(int type) {
        for (NotificationTypeEnum notificationTypeEnum : NotificationTypeEnum.values()) {
            if (notificationTypeEnum.getType() == type)
                return notificationTypeEnum.getName();
        }
        return "";
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    NotificationTypeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }
}
