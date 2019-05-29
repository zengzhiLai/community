package cn.lnsf.community.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ：赖增智
 * @date ：Created in 2019-5-29 0:57
 */
@Controller
public class HelloController {
    @GetMapping("/hello")//找到templates下的hello.html
    public String hello(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name",name);
        return "index";
    }

}
