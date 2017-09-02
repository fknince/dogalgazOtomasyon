/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VeritabaniIslemleri;

import apartman.apartman;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fince
 */
public class apartmanIslemleriDb {
    public apartman seciliApartmaniVer(String apartNo) throws ClassNotFoundException, SQLException
    {
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        String query="Select * from apartman where apartNo = ?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, apartNo);
        ResultSet rs=ps.executeQuery();
        rs.next();
        
        return new apartman(rs.getString(2),rs.getString(3));
        
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        //apartmanIslemleriDb aid=new apartmanIslemleriDb();
       
    }
    
}
