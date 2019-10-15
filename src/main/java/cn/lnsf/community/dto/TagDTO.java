package cn.lnsf.community.dto;

import lombok.Data;

import java.util.List;

/**
 * @author ：赖增智
 * @date ：Created in 2019-10-15 13:02
 */
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}
