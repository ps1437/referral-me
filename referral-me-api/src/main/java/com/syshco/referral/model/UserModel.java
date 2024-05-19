package com.syshco.referral.model;


import com.syshco.referral.entity.enums.Role;
import lombok.Data;

@Data
public class UserModel {

    private Long id;

    private String name;

    private String email;

    private Role role;

}
