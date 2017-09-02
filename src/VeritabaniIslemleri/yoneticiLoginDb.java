/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VeritabaniIslemleri;

import LoginKontrolIslemleri.MD5_encoder;
import com.mysql.jdbc.Connection;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fince
 */
public class yoneticiLoginDb {
   public boolean adminNoMevcutMu(String adminNo) throws ClassNotFoundException, SQLException
   {
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        
        String query="Select count(admin_No) from admin where admin_No=? ";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, adminNo);
        ResultSet rs=ps.executeQuery();
        rs.next();
        if(rs.getInt(1) == 0)
            return false;
        else
            return true;
       
   }
   public boolean sifreKontrol(String sifre,String uyeNo) throws ClassNotFoundException, NoSuchAlgorithmException, SQLException
   {
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        MD5_encoder md5e=new MD5_encoder();
        String hash=md5e.string2MD5(sifre);
        
        String query=" select l.sifre from login l,login_admin la where l.uyeNo = la.uyeNo and l.uyeNo= ?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, uyeNo);
        ResultSet rs=ps.executeQuery();
        rs.next();
        if(rs.getString(1).equals(hash))
           return true;
        else
            return false;
        
   }
    
}
