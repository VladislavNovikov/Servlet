package com.servlet;

public class Info {
    private User user;
    private Integer accountssum;

    Info(User user,Integer accountssum){
        this.user=user;
        this.accountssum=accountssum;
    }

    public User getUser() {
        return user;
    }

    public Integer getAccountssum() {
        return accountssum;
    }
}
