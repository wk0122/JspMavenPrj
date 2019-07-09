package tech.aistar.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author success
 * @version 1.0
 * @description:本类用来演示:用户实体类
 * @date 2019/6/3 0003
 */
public class User implements Serializable{
    private Integer id;

    private String username;

    private String password;

    private String phone;

    private Date birthday;

    private String headerUrl;//头像

    private int power;//0超级管理员,1普通

    public User(){

    }

    public User(Integer id, String username, String password, String phone, Date birthday, String headerUrl, int power) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.phone = phone;
        this.headerUrl = headerUrl;
        this.power = power;
    }

    public User(Integer id, String username, String password, Date birthday, String headerUrl, int power) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.headerUrl = headerUrl;
        this.power = power;
    }
    public User(String username, String password, String headerUrl, int power) {
        this.username = username;
        this.password = password;
        this.headerUrl = headerUrl;
        this.power = power;
    }
    public User(String username, String password, Date birthday, String headerUrl, int power) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.headerUrl = headerUrl;
        this.power = power;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHeaderUrl() {
        return headerUrl;
    }

    public void setHeaderUrl(String headerUrl) {
        this.headerUrl = headerUrl;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append(", headerUrl='").append(headerUrl).append('\'');
        sb.append(", power=").append(power);
        sb.append('}');
        return sb.toString();
    }
}
