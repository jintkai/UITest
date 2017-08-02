package com.jon.easywebPage.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GradeDomain {

    @JsonProperty
    private String grade;

    @JsonProperty
    private String gradeSub;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGradeSub() {
        return gradeSub;
    }

    public void setGradeSub(String gradeSub) {
        this.gradeSub = gradeSub;
    }

    public GradeDomain(String grade, String gradeSub) {
        this.grade = grade;
        this.gradeSub = gradeSub;
    }
}
