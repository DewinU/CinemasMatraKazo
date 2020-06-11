/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DewinU
 */
public class Database {
    String port = "5432";
    String dbName = "ddg41pao04e5s0";
    String host = "ec2-52-202-22-140.compute-1.amazonaws.com";
    String username = "maovjamkkiunpf";
    String password = "64ad2745e113a14da6e1e28a1b3b3435805cacce6e536887ef0df147f8935b3a";
    String dbUrl = "jdbc:postgresql://" + host + ":" + port + "/" + dbName + "?sslmode=require&user="
            + username + "&password=" +  password;
    Connection con;
    ResultSet rs;

    public Database() throws URISyntaxException, SQLException {
        this.con = getConnection();
    }

    private Connection getConnection() throws URISyntaxException, SQLException {
        return DriverManager.getConnection(dbUrl, username, password);
    }

    public boolean is_register(String username, String password) throws SQLException{
        rs = con.prepareStatement("SELECT username FROM users WHERE username='{" + username +
                "}' AND password='{" + password + "}'").executeQuery();

        return rs.next();
    }
    
}
