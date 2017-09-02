/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VeritabaniIslemleri;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author fince
 */
public class login2Panel {
    
    public void gecisYapildi(String uyeNo) throws ClassNotFoundException, SQLException
    {
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        
        String query="UPDATE aktif_uye SET uyeNo = ? ";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, uyeNo);
        ps.executeUpdate();
    }
    
    public String uyeNo_ver() throws ClassNotFoundException, SQLException
    {
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        
        String query="Select uyeNo from aktif_uye ";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        rs.next();
        return String.valueOf(rs.getInt(1));
        
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        //login2Panel l2p=new login2Panel();
    
    }
    
}
