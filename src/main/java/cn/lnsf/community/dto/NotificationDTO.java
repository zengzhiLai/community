package cn.lnsf.community.dto;

import lombok.Data;

/**
 * @author ：赖增智
 * @date ：Created in 2019-10-19 20:48
 */
@Data
public class NotificationDTO {
    private Long id;
    private Long gmtCreate;
    private Integer status;
    private Long notifier;
    private String notifierName;
    private String outerTitle;
    private Long outerId;
    private String typeName;
    private Integer type;
}
