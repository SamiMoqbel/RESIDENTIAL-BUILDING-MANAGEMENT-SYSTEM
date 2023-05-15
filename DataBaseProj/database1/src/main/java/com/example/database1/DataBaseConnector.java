package com.example.database1;

import java.sql.Connection;
import  java.sql.DriverManager;
public class DataBaseConnector {
    public Connection databaseLink;

    public Connection getConnection()throws NullPointerException{
        String databaseName="real_estate";
        String databaseUser="root";
        String databasePassword="sami4321";
        String url="jdbc:mysql://localhost/"+databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink =DriverManager.getConnection(url,databaseUser,databasePassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return databaseLink;
    }

}
