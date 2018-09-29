package com.study.dao.mybatis;

import com.study.api.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {
    MemberEntity findById (String id);
}
