package com.jon.easywebPage.register;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jon.easywebPage.common.GradeDomain;
import com.jon.easywebPage.school.SchoolDomain;

public class RegisterDomain {

    @JsonProperty
    private String userName;
    @JsonProperty
    private String passwd;
    @JsonProperty
    private String qqORmail;
    @JsonProperty
    private String identity;
    @JsonProperty
    private String realName;
    @JsonProperty
    private String mobile;
    @JsonProperty
    private SchoolDomain schoolDomain;
    @JsonProperty
    private GradeDomain gradeDomain;


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

    public String getQqORmail() {
        return qqORmail;
    }

    public void setQqORmail(String qqORmail) {
        this.qqORmail = qqORmail;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public SchoolDomain getSchoolDomain() {
        return schoolDomain;
    }

    public void setSchoolDomain(SchoolDomain schoolDomain) {
        this.schoolDomain = schoolDomain;
    }

    public GradeDomain getGradeDomain() {
        return gradeDomain;
    }

    public void setGradeDomain(GradeDomain gradeDomain) {
        this.gradeDomain = gradeDomain;
    }

    public RegisterDomain(String userName, String passwd, String qqORmail, String identity, String realName, String mobile, SchoolDomain schoolDomain, GradeDomain gradeDomain) {
        this.userName = userName;
        this.passwd = passwd;
        this.qqORmail = qqORmail;
        this.identity = identity;
        this.realName = realName;
        this.mobile = mobile;
        this.schoolDomain = schoolDomain;
        this.gradeDomain = gradeDomain;
    }
}
