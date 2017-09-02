/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VeritabaniIslemleri;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fince
 */
public class baglan {
    
    public Connection veritabanina_Baglan() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Connection");
        Connection con =(Connection)DriverManager.getConnection
        ("jdbc:mysql://localhost:3306/dogalgaz_otomasyon","root","174520");
        
        return con;
        
    }
    
}
