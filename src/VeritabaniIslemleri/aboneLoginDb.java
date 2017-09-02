/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VeritabaniIslemleri;

import LoginKontrolIslemleri.MD5_encoder;
import com.mysql.jdbc.Connection;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 *
 * @author fince
 */
public class aboneLoginDb {
    
    public boolean aboneNoMevcutMu(String aboneNo) throws ClassNotFoundException, SQLException
    {
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        
        String query="Select count(aboneNo) from abone where aboneNo=? ";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, aboneNo);
        ResultSet rs=ps.executeQuery();
        rs.next();
        if(rs.getInt(1) == 0)
            return false;
        else
            return true;
        
        
        
        
        
    }
    
    public boolean sifreKontrol(String sifre,String uyeNo) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException
    {
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        MD5_encoder md5e=new MD5_encoder();
        String hash=md5e.string2MD5(sifre);
        
        String query=" select l.sifre from login l,login_abone la where l.uyeNo = la.uyeNo and l.uyeNo= ?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, uyeNo);
        ResultSet rs=ps.executeQuery();
        rs.next();
        if(rs.getString(1).equals(hash))
           return true;
        else
            return false;
        
    }
   public String uyeNoVer(String aboneNo) throws ClassNotFoundException, SQLException
   {
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
       
        
        String query=" select l.uyeNo from login l,login_abone la where l.uyeNo = la.uyeNo and la.aboneNo= ?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, aboneNo);
        ResultSet rs=ps.executeQuery();
        rs.next();
        return String.valueOf(rs.getInt(1));
   }

   public String sonGirisTarihi(String uyeNo) throws ClassNotFoundException, SQLException
    {
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        
        String query="Select sgt from login where uyeNo=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, uyeNo);
        ResultSet rs=ps.executeQuery();
        rs.next();
        Date gelen=rs.getDate(1);
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        String donecek=DATE_FORMAT.format(gelen);
        return donecek;
        
    }
    public void sonGirisTarihiGuncelle(String uyeNo) throws ClassNotFoundException, SQLException
    {
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        
        String query="Update login set sgt=(select curdate()) where uyeNo=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, uyeNo);
        ps.executeUpdate();
        
        
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException
    {
        //aboneLoginDb ald=new aboneLoginDb();
        
        
       
    }
    
}
