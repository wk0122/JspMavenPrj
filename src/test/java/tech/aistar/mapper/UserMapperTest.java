package tech.aistar.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tech.aistar.util.MyBstisUtil;

/**
 * Created by js on 2019/6/13.
 */
public class UserMapperTest {
    private SqlSession sqlSession;
    private UserMapper mapper;

    @Before
    public void initMapper(){
         sqlSession= MyBstisUtil.getSession();
        mapper=sqlSession.getMapper(UserMapper.class);
    }
    @Test
    public void testFindByPhone(){
        System.out.println(mapper.findByPhone("15656939005"));
    }


    @After
    public void closeMapper(){
        sqlSession.commit();
        sqlSession.close();
    }
}
