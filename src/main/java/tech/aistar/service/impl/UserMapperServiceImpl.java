package tech.aistar.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import tech.aistar.entity.User;
import tech.aistar.mapper.UserMapper;
import tech.aistar.service.UserMapperService;
import tech.aistar.util.MyBstisUtil;

import java.util.List;

/**
 * Created by js on 2019/6/13.
 */
public class UserMapperServiceImpl implements UserMapperService {
    @Override
    public User getByPhone(String phone) {
        SqlSession sqlSession= MyBstisUtil.getSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User user=mapper.findByPhone(phone);
        return user;
    }

    @Override
    public PageInfo<User> getPageInfo(String username, Integer pageNow, Integer pageSize) {

        PageHelper.startPage(pageNow==null?1:pageNow,pageSize==null?3:pageSize);

        SqlSession sqlSession=MyBstisUtil.getSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);

        //需要分页的数据 如果没有输入用户查询所有
        List<User> users=mapper.findAll(username==null?"":username);
        PageInfo<User> pageInfo=new PageInfo<>(users);
        sqlSession.close();


        return pageInfo;
    }
}
