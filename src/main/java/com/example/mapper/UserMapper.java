package com.example.mapper;

import com.example.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author L.F.Q
 * @date 2019/5/19 17:51
 */
public interface UserMapper {
    User findByUsername(@Param("username")String username);
}
