package cn.lnsf.community.controller;

import cn.lnsf.community.cache.HotTagCache;
import cn.lnsf.community.dto.PaginationDTO;
import cn.lnsf.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 首页
 *
 * @author ：zengzhilai
 * @date ：Created in 2019-5-29 0:57
 */
@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private HotTagCache hotTagCache;

    @GetMapping("/")
    public String index(
            Model model,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "size", defaultValue = "2") Integer size,
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "tag", required = false) String tag
    ) {
        PaginationDTO pagination = questionService.list(search, tag, page, size);
        List<String> tags = hotTagCache.getHots();
        model.addAttribute("pagination", pagination);
        model.addAttribute("search", search);
        model.addAttribute("tag", tag);
        model.addAttribute("tags", tags);
        return "index";
    }
}
