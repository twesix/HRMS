package com.vanging.hrms.persistence.models;

public class Profile
{
    private String id; // id card number
    private String username;
    private String usertype; // hour, salary, commission
    private String tel;
    private float salary_per_hour;
    private float salary_fixed;
    private float salary_rate;
    private int hour_limit;
    private String pay_method;
    private String pay_detail;

    public String getPay_detail() {
        return pay_detail;
    }

    public void setPay_detail(String pay_detail) {
        this.pay_detail = pay_detail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPay_method() {
        return pay_method;
    }

    public void setPay_method(String pay_method) {
        this.pay_method = pay_method;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public float getSalary_per_hour() {
        return salary_per_hour;
    }

    public void setSalary_per_hour(float hourly_rate) {
        this.salary_per_hour = hourly_rate;
    }

    public float getSalary_fixed() {
        return salary_fixed;
    }

    public void setSalary_fixed(float salary_fixed) {
        this.salary_fixed = salary_fixed;
    }

    public float getSalary_rate() {
        return salary_rate;
    }

    public void setSalary_rate(float salary_rate) {
        this.salary_rate = salary_rate;
    }

    public int getHour_limit() {
        return hour_limit;
    }

    public void setHour_limit(int hour_limit) {
        this.hour_limit = hour_limit;
    }
}
