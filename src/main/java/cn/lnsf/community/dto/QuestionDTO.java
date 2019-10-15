package cn.lnsf.community.dto;

import cn.lnsf.community.model.User;
import lombok.Data;

/**
 * @author ：赖增智
 * @date ：Created in 2019-9-23 15:53
 */
@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
