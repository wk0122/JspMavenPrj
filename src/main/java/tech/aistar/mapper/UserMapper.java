package tech.aistar.mapper;

import org.apache.ibatis.annotations.Select;
import tech.aistar.entity.User;

import java.util.List;

/**
 * Created by js on 2019/6/13.
 */
public interface UserMapper {

    @Select("select * from jsp_user where phone=#{value}")
    User findByPhone(String phone);

    @Select("select * from jsp_user where username like concat('%',#{value},'%')")
    List<User> findAll(String username);
}
