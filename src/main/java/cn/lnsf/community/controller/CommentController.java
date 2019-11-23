package cn.lnsf.community.controller;

import cn.lnsf.community.dto.CommentCreateDTO;
import cn.lnsf.community.dto.CommentDTO;
import cn.lnsf.community.dto.ResultDTO;
import cn.lnsf.community.enums.CommentTypeEnum;
import cn.lnsf.community.exception.CustomizeErrorCode;
import cn.lnsf.community.mapper.CommentMapper;
import cn.lnsf.community.model.Comment;
import cn.lnsf.community.model.User;
import cn.lnsf.community.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 评论
 *
 * @author ：赖增智
 * @date ：Created in 2019-10-5 1:16
 */
@Controller
public class CommentController {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentCreateDTO commentCreateDTO, HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }

        // 判断 commentCreateDTO.getContent() == null || commentCreateDTO.getContent() == ""
        if (commentCreateDTO == null || StringUtils.isBlank(commentCreateDTO.getContent())) {
            return ResultDTO.errorOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
        }

        Comment comment = new Comment();
        comment.setParentId(commentCreateDTO.getParentId());
        comment.setContent(commentCreateDTO.getContent());
        comment.setType(commentCreateDTO.getType());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        comment.setLikeCount(0L);
        commentService.insert(comment, user);

        return ResultDTO.okOf();
    }

    @ResponseBody
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public ResultDTO<List<CommentDTO>> comments(@PathVariable(name = "id") Long id) {
        List<CommentDTO> commentDTOS = commentService.listByTargetId(id, CommentTypeEnum.COMMENT);
        return ResultDTO.okOf(commentDTOS);
    }

}
