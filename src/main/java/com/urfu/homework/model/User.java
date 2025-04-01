package com.urfu.homework.model;

import com.urfu.homework.validation.ValidLogin;
import com.urfu.homework.validation.NoSpecialChars;

public class User {
    @ValidLogin
    private String login;

    @NoSpecialChars
    private String nickname;

}
