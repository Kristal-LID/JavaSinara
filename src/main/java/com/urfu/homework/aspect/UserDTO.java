package com.urfu.homework.aspect;

public class UserDTO {
    private Integer userId;


    public UserDTO(Integer userId) {
        this.userId = userId;

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
