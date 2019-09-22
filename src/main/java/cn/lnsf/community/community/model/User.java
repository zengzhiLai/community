package cn.lnsf.community.community.model;

import lombok.Data;

/**
 * @author ：赖增智
 * @date ：Created in 2019-9-12 21:50
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
