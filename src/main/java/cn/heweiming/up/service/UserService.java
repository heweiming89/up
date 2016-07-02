package cn.heweiming.up.service;

import java.util.List;

import cn.heweiming.up.model.User;

public interface UserService {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}
