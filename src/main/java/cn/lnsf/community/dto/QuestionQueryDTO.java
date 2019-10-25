package cn.lnsf.community.dto;

import lombok.Data;

/**
 * @author ：zengzhilai
 * @date ：Created in 2019-10-23 14:51
 */
@Data
public class QuestionQueryDTO {
    private String search;
    private String tag;
    private Integer page;
    private Integer size;
}
