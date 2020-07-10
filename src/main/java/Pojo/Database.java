/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;
import Model.UserTableModel;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

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
    PreparedStatement query;

    String checkLogin = "SELECT * from check_login(?,?)";
    String createEmpleado ="SELECT add_empleado(?,?,?,?,?,?,?,?,?,?,?,?,?)"; //C
    String readAll = "SELECT * from users";                                //R
    String updateEmpleado = "SELECT edit_empleado(?,?,?,?,?,?,?,?,?,?,?,?,?)"; //U
    String deleteEmpleado = "SELECT delete_empleado(?)";                   //R

    public Database() throws SQLException {
        con = getConnection();
        con.setAutoCommit(false);
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, username, password);
    }

    public String[] is_register(String username, String password) throws SQLException{
        String[] usuario = new String[2];
        String firstName = null;
        String cargo = null;
        query = con.prepareStatement(checkLogin);
        query.setString(1,username);
        query.setString(2,password);
        rs = query.executeQuery();
        while (rs.next()){
             firstName = rs.getString(1);
             cargo = rs.getString(2);
        }
        usuario[0] = firstName;
        usuario[1] = cargo;
        return usuario;
    }

    public void showAll(ObservableList<UserTableModel> obList) throws SQLException {
        query = con.prepareStatement(readAll);
        rs = query.executeQuery();
        while(rs.next()) {
            obList.add(new UserTableModel(rs.getInt(1),rs.getString(2),
                    rs.getString(3),rs.getString(4),rs.getString(5),
                    rs.getString(6),rs.getString(7),rs.getString(8),
                    rs.getString(9),rs.getString(10),
                    rs.getDate(11), rs.getString(12),rs.getString(13),
                    rs.getString(14)));
        }
    }

    public void addEmpleado(String cod, String username, String password,
                               String firstName, String lastName, String cedula, String telefono,
                               String email,String address, String cargo, String turno, String fotoUrl) throws SQLException {
        query = con.prepareStatement(createEmpleado);
        query.setString(1,cod);
        query.setString(2,username);
        query.setString(3,password);
        query.setString(4,firstName);
        query.setString(5,lastName);
        query.setString(6,cedula);
        query.setString(7,telefono);
        query.setString(8,email);
        query.setString(9,address);
        query.setObject(10, LocalDate.now());
        query.setString(11,cargo);
        query.setString(12,turno);
        query.setString(13,fotoUrl);
        query.executeUpdate();
    }

    public void updateEmpleado(int id,String cod, String username,String firstName, String lastName, String cedula, String telefono,
                               String email,String address,String cargo, String turno, String fotoUrl) throws SQLException {
        query = con.prepareStatement(updateEmpleado);
        query.setInt(1,id);
        query.setString(2,cod);
        query.setString(3,username);
        query.setString(4,firstName);
        query.setString(5,lastName);
        query.setString(6,cedula);
        query.setString(7,telefono);
        query.setString(8,email);
        query.setString(9,address);
        query.setObject(10,LocalDate.now());
        query.setString(11,cargo);
        query.setString(12,turno);
        query.setString(13,fotoUrl);
        query.executeUpdate();
    }

    public void deleteEmpleado(int index) throws SQLException {
        query = con.prepareStatement(updateEmpleado);
        query.setInt(1,index);
        query.executeUpdate();
    }
    
}
