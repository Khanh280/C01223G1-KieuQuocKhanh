package com.casestudy.happy_paws.dto;

import javax.persistence.*;
import javax.validation.constraints.Size;

public class RoleDTO {

    private Integer roleId;


    @Size(max = 100 , message = "name role cannot longger than 100 character !!!!")
    private String nameRole;

    public RoleDTO(Integer roleId, String nameRole) {
        this.roleId = roleId;
        this.nameRole = nameRole;
    }

    public RoleDTO() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }
}
