package tech.aistar.service;

import com.github.pagehelper.PageInfo;
import tech.aistar.entity.User;

/**
 * Created by js on 2019/6/13.
 */
public interface UserMapperService {

    User getByPhone(String phone);

    //分页查询
    PageInfo<User> getPageInfo(String username, Integer pageNow, Integer pageSize);

}
