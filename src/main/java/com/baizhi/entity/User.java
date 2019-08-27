package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;

import java.util.Date;


public class User {

    @ExcelIgnore
    private String id;
    @Excel(name = "电话")
    private String phone;
    @Excel(name = "用户")
    private String username;
    private String password;
    private String salt;
    @Excel(name = "法号")
    private String dharma;
    @Excel(name = "省份")
    private String province;
    @Excel(name = "城市")
    private String city;
    @Excel(name = "签名")
    private String sign;
    private String photo;
    @Excel(name = "性别")
    private String sex;
    @Excel(name = "创建时间", orderNum = "3", format = "yyyy-MM-dd", width = 30)
    private Date createDate;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", dharma='" + dharma + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", sign='" + sign + '\'' +
                ", photo='" + photo + '\'' +
                ", sex='" + sex + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getDharma() {
        return dharma;
    }

    public void setDharma(String dharma) {
        this.dharma = dharma;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User() {
    }

    public User(String id, String phone, String username, String password, String salt, String dharma, String province, String city, String sign, String photo, String sex, Date createDate) {
        this.id = id;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.dharma = dharma;
        this.province = province;
        this.city = city;
        this.sign = sign;
        this.photo = photo;
        this.sex = sex;
        this.createDate = createDate;
    }
}
