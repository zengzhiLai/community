package cn.lnsf.community.dto;

import lombok.Data;

/**
 * @author ：zengzhilai
 * @date ：Created in 2019-10-25 20:19
 */
@Data
public class HotTagDTO implements Comparable {
    private String name;
    private Integer priority;

    @Override
    public int compareTo(Object o) {
        return this.getPriority() - ((HotTagDTO) o).getPriority();
    }
}
