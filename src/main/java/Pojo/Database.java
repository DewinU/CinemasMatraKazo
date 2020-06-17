/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;
import Model.TableModel;
import javafx.collections.ObservableList;

import java.sql.*;

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

    String checkLogin = "SELECT check_login(?, ?)";
    String createEmpleado ="SELECT add_empleado(?,?,?,?,?,?,?,?,?,?,?,?)"; //C
    String readAll = "SELECT * from users";                                //R
    String updateEmpleado = "SELECT edit_empleado(?,?,?,?,?,?,?,?,?,?,?)"; //U
    String deleteEmpleado = "SELECT delete_empleado(?)";                   //R

    public Database() throws SQLException {
        con = getConnection();
        con.setAutoCommit(false);
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, username, password);
    }

    public boolean is_register(String username, String password) throws SQLException{

        query = con.prepareStatement(checkLogin);
        query.setString(1,username);
        query.setString(2,password);

        return query.execute();
    }

    public void showAll(ObservableList<TableModel> obList) throws SQLException {
        query = con.prepareStatement(readAll);
        rs = query.executeQuery();
        while(rs.next()) {
            obList.add(new TableModel(rs.getInt("id"),rs.getString("cod"),
                    rs.getString("username"),rs.getString("firstname"),
                    rs.getString("lastname"),rs.getString("cedula"),
                    rs.getString("telefono"),rs.getString("email"),
                    rs.getString("cargo"),rs.getString("turno"),
                    rs.getDate("hiredate")));
        }
    }

    public boolean addEmpleado(String cod, String username,
                               String firstName, String lastName, String cedula, String telefono,
                               String email,String address, String cargo, String turno, String fotoUrl) throws SQLException {
        query = con.prepareStatement(createEmpleado);
        query.setString(1,cod);
        query.setString(2,username);
        query.setString(3,firstName);
        query.setString(4,lastName);
        query.setString(5,cedula);
        query.setString(6,telefono);
        query.setString(7,email);
        query.setString(8,address);
        query.setString(9,cargo);
        query.setString(10,turno);
        query.setString(11,fotoUrl);
        return query.execute();
    }

    public boolean updateEmpleado(String cod, String username,String password,
                                  String firstName, String lastName, String cedula, String telefono,
                                  String email,String address, String cargo, String turno, String fotoUrl) throws SQLException {
        query = con.prepareStatement(updateEmpleado);
        query.setString(1,cod);
        query.setString(2,username);
        query.setString(3,firstName);
        query.setString(4,lastName);
        query.setString(5,cedula);
        query.setString(6,telefono);
        query.setString(7,email);
        query.setString(8,address);
        query.setString(9,cargo);
        query.setString(10,turno);
        query.setString(11,fotoUrl);

        return query.execute();
    }
    
}
