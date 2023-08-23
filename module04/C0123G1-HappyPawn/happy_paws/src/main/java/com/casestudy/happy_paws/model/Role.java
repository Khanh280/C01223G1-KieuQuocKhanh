package com.casestudy.happy_paws.model;


import javax.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;


    @Column(name = "name_role", nullable = false, columnDefinition = "VARCHAR(100)")
    private String nameRole;

    public Role(Integer roleId, String nameRole) {
        this.roleId = roleId;
        this.nameRole = nameRole;
    }

    public Role() {
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

