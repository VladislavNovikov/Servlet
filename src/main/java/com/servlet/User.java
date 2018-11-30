package com.servlet;

import java.util.Comparator;

public class User {

    private String UserName;
    private String UserSureName;
    private Integer UserAccount;

    User(String UserName,String UserSureName, Integer UserAccount){
        super();
        this.UserName=UserName;
        this.UserSureName=UserSureName;
        this.UserAccount= UserAccount;
    }
    public static final Comparator<User> COMPAREBYACCOUNT = new Comparator<User>() {
        public int compare(User o1, User o2) {
            return o1.getUserAccount().compareTo(o2.getUserAccount());
        }
    };

    public String getUserName() {
        return UserName;
    }

    public String getUserSureName() {
        return UserSureName;
    }

    public Integer getUserAccount() {
        return UserAccount;
    }

    @Override
    public String toString() {
        return UserName + " " + UserSureName + ", his userId = " + Integer.toString(UserAccount)+ ".";
    }

}
