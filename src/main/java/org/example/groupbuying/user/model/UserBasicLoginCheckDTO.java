package org.example.groupbuying.user.model;

public class UserBasicLoginCheckDTO {
    private String userEmail;
    private String userStatus;

    public UserBasicLoginCheckDTO() {
    }

    @Override
    public String toString() {
        return "UserBasicLoginCheckDTO{" +
                "userEmail='" + userEmail + '\'' +
                ", userStatus='" + userStatus + '\'' +
                '}';
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public UserBasicLoginCheckDTO(String userEmail, String userStatus) {
        this.userEmail = userEmail;
        this.userStatus = userStatus;
    }
}
