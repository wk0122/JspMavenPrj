package tech.aistar.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by js on 2019/5/9.
 */
public class MyBstisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    //静态代码块来初始化
    static{
        InputStream in=null;

        try {
            in= Resources.getResourceAsStream("mybatis-config.xml");

            sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }

    public static void closeSession(SqlSession sqlSession){
        if (null!=sqlSession){
            sqlSession.close();
        }
    }

}
