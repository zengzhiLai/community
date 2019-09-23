package cn.lnsf.community.community.dto;

import cn.lnsf.community.community.model.User;
import lombok.Data;

/**
 * @author ：赖增智
 * @date ：Created in 2019-9-23 15:53
 */
@Data
public class QuestionDTO {
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
    private User user;
}
