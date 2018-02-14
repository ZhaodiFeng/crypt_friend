package com.bewire.Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_role", schema = "crypt_friend", catalog = "")
public class UserRole {
    private int id;
    private String userId;
    private int roleId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "User_Id", nullable = false, length = 21)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    @Column(name = "Role_Id", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return id == userRole.id &&
                roleId == userRole.roleId &&
                Objects.equals(userId, userRole.userId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, roleId);
    }
}
