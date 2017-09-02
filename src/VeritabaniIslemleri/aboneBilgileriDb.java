/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VeritabaniIslemleri;

import abonePaneliIslemleri.abone;
import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 *
 * @author fince
 */
public class aboneBilgileriDb {
    
    public abone seciliAboneyiVer(String aboneNo) throws ClassNotFoundException, SQLException
    {
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        
        String query="Select * from abone where aboneNo=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, aboneNo);
        ResultSet rs=ps.executeQuery();
        rs.next();
        Date gelen=rs.getDate(8);
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        String donecek=DATE_FORMAT.format(gelen);
        
       return new abone(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
        rs.getString(6),String.valueOf(rs.getInt(7)),donecek,String.valueOf(rs.getInt(9)));
      
    }
    
    public boolean aboneBilgileriGuncelle(String aboneNo,String ad,String soyad,String telefonNo)
    {
        try
        {
            baglan b=new baglan();
            Connection con=b.veritabanina_Baglan();
            String query="UPDATE abone SET ad = ? , soyad = ? ,telefon_No = ? where aboneNo = ?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, ad);
            ps.setString(2, soyad);
            ps.setString(3, telefonNo);
            ps.setString(4, aboneNo);
            ps.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
        
        
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        //aboneBilgileriDb abd=new aboneBilgileriDb();
        
        
    }
    
}
