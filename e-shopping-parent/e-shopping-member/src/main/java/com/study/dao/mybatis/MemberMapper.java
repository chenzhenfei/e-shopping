package com.study.dao.mybatis;

import com.study.api.entity.MemberEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
public interface MemberMapper {

    @Select("select  id,username,password,phone,email,created,updated from mb_user where id =#{userId}")
    MemberEntity findById(@Param("userId") long userId);


    @Insert("INSERT  INTO `mb_user`  (username,password,salt,phone,email,created,updated) VALUES (#{username}, #{password},#{salt},#{phone},#{email},#{created},#{updated});")
    Integer insertUser(MemberEntity userEntity);
}
