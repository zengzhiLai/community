package cn.lnsf.community.community.model;

import lombok.Data;

/**
 * @author ：赖增智
 * @date ：Created in 2019-9-20 20:27
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
}
