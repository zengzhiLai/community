package cn.lnsf.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：赖增智
 * @date ：Created in 2019-9-27 11:32
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;//记录问题
    private boolean showPrevious; //展示前一页
    private boolean showFistPage; //展示第一页
    private boolean showNext; //展示下一页
    private boolean showEndPage; //展示最后一页
    private Integer page;  //当前页
    private List<Integer> pages = new ArrayList<>();//记录页码
    private Integer totalPage; //总页数

    public void setPagination(Integer totalPage, Integer page) {

        this.totalPage = totalPage;
        this.page = page;

        //分页
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

        //是否展示上一页
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }

        //是否展示下一页
        if (page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }

        //是否展示第一页
        if (pages.contains(1)) {
            showFistPage = false;
        } else {
            showFistPage = true;
        }

        //是否展示最后一页
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }

    }
}
