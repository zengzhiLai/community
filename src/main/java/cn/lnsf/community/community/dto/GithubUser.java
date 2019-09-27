package cn.lnsf.community.community.dto;

import lombok.Data;

/**
 * https://api.github.com/users/zengzhilai
 * @author ：赖增智
 * @date ：Created in 2019-6-1 22:14
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl; //头像地址
}
