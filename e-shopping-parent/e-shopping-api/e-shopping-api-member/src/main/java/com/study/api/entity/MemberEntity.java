package com.study.api.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
@Getter
@Setter
public class MemberEntity {
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String phone;
    private String email;
    private Date created;
    private Date updated;
}
