/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnect {

    String servername;
    String port;
    String db_name;
    String db_user;
    String db_pass;

    public MyConnect() {
        servername = "127.0.0.1";
        port = "1433";
        db_name = "asm"; //tên  database
        db_user = "sa";
        db_pass = "songlong"; // password kết nối vào MS SQL
    }

    public Connection getcn() {
        Connection cn = null;
        try {   //Database url
            String db_url = "jdbc:sqlserver://" + servername + ":" + port + ";databasename=" + db_name;

            //Load JDBC           
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //Ketnoivoi database
            cn = DriverManager.getConnection(db_url, db_user, db_pass);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cn;
    }
}
