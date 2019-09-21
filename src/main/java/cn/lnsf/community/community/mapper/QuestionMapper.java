package cn.lnsf.community.community.mapper;

import cn.lnsf.community.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ：赖增智
 * @date ：Created in 2019-9-20 20:19
 */
@Mapper
public interface QuestionMapper {

    @Insert("insert into question (title,description,tag,gmt_create,gmt_modified,creator) values (#{title},#{description},#{tag},#{gmtCreate},#{gmtModified},#{creator})")
    void create(Question question);
}
