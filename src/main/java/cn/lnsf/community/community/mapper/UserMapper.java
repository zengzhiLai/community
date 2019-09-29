package cn.lnsf.community.community.mapper;

import cn.lnsf.community.community.model.User;
import org.apache.ibatis.annotations.*;

/**
 * @author ：赖增智
 * @date ：Created in 2019-9-12 21:43
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    //不是对象，需要引入@Param
    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);

    @Select("select * from user where account_id = #{accountId}")
    User findByAccountId(@Param(value = "accountId") String accountId);

    @Update("update user set name = #{name},token=#{token},gmt_modified=#{gmtModified},avatar_url=#{avatarUrl} where id=#{id}")
    void update(User dbUser);
}
