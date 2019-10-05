package cn.lnsf.community.controller;

import cn.lnsf.community.dto.QuestionDTO;
import cn.lnsf.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ：赖增智
 * @date ：Created in 2019-9-29 14:47
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(
            @PathVariable(name = "id") Long id,
            Model model) {

        QuestionDTO questionDTO = questionService.getById(id);

        questionService.incView(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }

}
