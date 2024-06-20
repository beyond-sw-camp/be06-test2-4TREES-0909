package org.example.groupbuying.user.model;

public class UserBasicLoginRes {
    private boolean isSuccess;
    private Integer code;
    private String message;

    public UserBasicLoginRes() {
    }

    public UserBasicLoginRes(boolean isSuccess, Integer code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "UserBasicLoginRes{" +
                "isSuccess=" + isSuccess +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
