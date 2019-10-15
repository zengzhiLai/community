package cn.lnsf.community.mapper;

import cn.lnsf.community.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}