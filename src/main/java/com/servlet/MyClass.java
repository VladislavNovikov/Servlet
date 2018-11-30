package com.servlet;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MyClass {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";
    //private static final String URL = "jdbc:mysql://localhost:3306/database?useSSL=false";
    private static final String URL = "jdbc:mysql://localhost:3306/database?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static void init() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Driver driver = new FabricMySQLDriver();
            //DriverManager.registerDriver(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Произошла ошибка");
            return;
        }
    }
    public static Info getInfoFromBD() {
        List<User> ListOfUsers = new  ArrayList<User>();

        try {Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet res =  statement.executeQuery("SELECT * FROM `database`.account join `database`.user on account.userId=user.userId");

            User user;
            while(res.next()){
               user  = new User(res.getString("name"),res.getString("sureName"),res.getInt("account"));
                ListOfUsers.add(user);
            }

            res.close();

            Collections.sort(ListOfUsers,User.COMPAREBYACCOUNT);

        }catch(SQLException e){
            e.printStackTrace();
        }
        return new Info(ListOfUsers.get(ListOfUsers.size()-1),ListOfUsers.size());
    }
}
