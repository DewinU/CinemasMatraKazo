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
    private String port = "5432";
    private String dbName = "ddg41pao04e5s0";
    private String host = "ec2-52-202-22-140.compute-1.amazonaws.com";
    private String username = "maovjamkkiunpf";
    private String password = "64ad2745e113a14da6e1e28a1b3b3435805cacce6e536887ef0df147f8935b3a";
    private String dbUrl = "jdbc:postgresql://" + host + ":" + port + "/" + dbName + "?sslmode=require&user="
            + username + "&password=" +  password;
    private String checkLogin = "SELECT * from check_login(?,?)";
    private String readAll = "SELECT * from users";
    private Connection con;
    private ResultSet rs;
    private PreparedStatement query;

    private String create_Empleado ="Insert into users(cod,username,password,firstname,lastname,cedula,telefono,email,address,hiredate,cargo,turno,fotourl) Values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private String update_Empleado = "UPDATE users SET cod = ?,username = ?,firstname = ?,lastname= ?,cedula =?,telefono = ?,email=?,address=?, cargo= ?, turno = ?, fotourl=? WHERE id = ?";

    public Database() throws SQLException {
        con = getConnection();
        con.setAutoCommit(false);
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, username, password);
    }

    public String[] is_register(String username, String password) throws SQLException{
        String[] usuario = new String[3];
        String firstName = null;
        String cargo = null;
        String carnet = null;
        query = con.prepareStatement(checkLogin);
        query.setString(1,username);
        query.setString(2,password);
        rs = query.executeQuery();
        while (rs.next()){
            carnet = rs.getString(1);
            firstName = rs.getString(2);
            cargo = rs.getString(3);

        }
        usuario[0] = carnet;
        usuario[1] = firstName;
        usuario[2] = cargo;
        query.close();
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
                    rs.getString(11), rs.getString(12),rs.getString(13),
                    rs.getString(14)));
        }
        query.close();
    }

    public void addEmpleado(String cod, String username, String password,
                               String firstName, String lastName, String cedula, String telefono,
                               String email,String address,String  date, String cargo, String turno, String fotoUrl) throws SQLException {
        query = getConnection().prepareStatement(create_Empleado);
        query.setString(1, cod);
        query.setString(2, username);
        query.setString(3, password);
        query.setString(4,firstName);
        query.setString(5,lastName);
        query.setString(6,cedula);
        query.setString(7,telefono);
        query.setString(8,email);
        query.setString(9,address);
        query.setString(10,date);
        query.setString(11,cargo);
        query.setString(12,turno);
        query.setString(13,fotoUrl);
        query.executeUpdate();
        query.close();

    }

    public void updateEmpleado(int id,String cod, String username,String firstName, String lastName, String cedula, String telefono,
                               String email,String address,String cargo, String turno, String fotoUrl) throws SQLException {
        query = getConnection().prepareStatement(update_Empleado);
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
        query.setInt(12,id);
        query.executeUpdate();
        query.close();
    }

    public void deleteEmpleado(int index) throws SQLException {
        String sql = "delete from users where id=?";
        query = getConnection().prepareStatement(sql);
        query.setInt(1,index);
        query.executeUpdate();
        query.close();
    }
    
}
