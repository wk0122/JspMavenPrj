package tech.aistar.service;

import org.junit.Test;
import tech.aistar.service.impl.UserMapperServiceImpl;

/**
 * Created by js on 2019/6/13.
 */
public class UserMapperServiceTest {

    private UserMapperService mapper=new UserMapperServiceImpl();

    @Test
    public void testFindByPhone(){
        System.out.println(mapper.getByPhone("15656939005"));
    }
}
