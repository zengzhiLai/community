package cn.lnsf.community.dto;

import lombok.Data;

/**
 * @author ：赖增智
 * @date ：Created in 2019-10-5 1:22
 */
@Data
public class CommentDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
