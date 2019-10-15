package cn.lnsf.community.dto;

import cn.lnsf.community.model.User;
import lombok.Data;

/**
 * @author ：赖增智
 * @date ：Created in 2019-10-13 16:26
 */
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private String content;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private Integer commentCount;
    private User user;
}
