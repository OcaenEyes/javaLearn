package entity;

import java.util.Date;

public class Users {
    private String username;
    private String password;
    private String eamil;
    private String gender;
    private Date birthday;
    private String[] favorite;
    private String introduce;
    private boolean accept;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEamil() {
        return eamil;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String[] getFavorite() {
        return favorite;
    }

    public String getIntroduce() {
        return introduce;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setFavorite(String[] favorite) {
        this.favorite = favorite;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }
}
