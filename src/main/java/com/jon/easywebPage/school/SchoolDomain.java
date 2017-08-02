package com.jon.easywebPage.school;

import com.fasterxml.jackson.annotation.*;
public class SchoolDomain {

    @JsonProperty
    private String provice;
    private String city;
    private String subdistrict;
    private String schoolName;

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSubdistrict() {
        return subdistrict;
    }

    public void setSubdistrict(String subdistrict) {
        this.subdistrict = subdistrict;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public SchoolDomain(String provice, String city, String subdistrict, String schoolName) {
        this.provice = provice;
        this.city = city;
        this.subdistrict = subdistrict;
        this.schoolName = schoolName;
    }
}
