package cn.lnsf.community.community.service;

import cn.lnsf.community.community.mapper.UserMapper;
import cn.lnsf.community.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：赖增智
 * @date ：Created in 2019-9-29 19:41
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void createOrInsert(User user) {
        User dbUser = userMapper.findByAccountId(user.getAccountId());

        if (dbUser == null) {
            //插入操作
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);

        } else {
            //更新操作
            dbUser.setGmtModified(System.currentTimeMillis());
            dbUser.setAvatarUrl(user.getAvatarUrl());
            dbUser.setName(user.getName());
            dbUser.setToken(user.getToken());
            userMapper.update(dbUser);
        }

    }
}
