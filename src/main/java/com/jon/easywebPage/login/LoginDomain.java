package com.jon.easywebPage.login;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginDomain {

    @JsonProperty
    private String userName;
    @JsonProperty
    private String passwd;

    public LoginDomain(String userName, String passwd) {
        this.userName = userName;
        this.passwd = passwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
