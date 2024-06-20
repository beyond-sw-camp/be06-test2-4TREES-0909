package org.example.groupbuying.user.model;


public class UserBasicSignupReq {

    private String userType;
    private String userName;
    private String userBirth;
    private String userSex;
    private String userEmail;
    private String userPassword;
    private String address;
    private String userPhoneNumber;

    public UserBasicSignupReq() {
    }

    @Override
    public String toString() {
        return "UserBasicSignupReq{" +
                "userType='" + userType + '\'' +
                ", userName='" + userName + '\'' +
                ", userBirth='" + userBirth + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", address='" + address + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                '}';
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public UserBasicSignupReq(String userType, String userName, String userBirth, String userSex, String userEmail, String userPassword, String address, String userPhoneNumber) {
        this.userType = userType;
        this.userName = userName;
        this.userBirth = userBirth;
        this.userSex = userSex;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.address = address;
        this.userPhoneNumber = userPhoneNumber;
    }
}
