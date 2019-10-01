package cn.lnsf.community.service;

import cn.lnsf.community.mapper.UserMapper;
import cn.lnsf.community.model.User;
import cn.lnsf.community.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：赖增智
 * @date ：Created in 2019-9-29 19:41
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void createOrInsert(User user) {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(userExample);

        if (users.size() == 0) {
            //插入操作
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);

        } else {
            //更新操作
            //数据库中的数据
            User dbUser = users.get(0);

            //要更新的数据
            User updateUser = new User();
            updateUser.setGmtModified(System.currentTimeMillis());
            updateUser.setAvatarUrl(user.getAvatarUrl());
            updateUser.setName(user.getName());
            updateUser.setToken(user.getToken());

            UserExample example = new UserExample();
            example.createCriteria().andIdEqualTo(dbUser.getId());

            userMapper.updateByExample(updateUser, example);
        }

    }
}
