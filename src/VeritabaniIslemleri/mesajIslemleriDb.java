/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VeritabaniIslemleri;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import mesaj.mesaj;

/**
 *
 * @author fince
 */
public class mesajIslemleriDb {
    public int aboninOkunmayanMesajiVarMi(String uyeNo) throws ClassNotFoundException, SQLException
    {
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        String query="Select count(mesajNo) from mesaj where alici=? and okundu='hayir'";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, uyeNo);
        ResultSet rs=ps.executeQuery();
        rs.next();
        return rs.getInt(1);
        
    }
    
    public mesaj aliciNoyaGoreMesajVer(String aliciNo) throws ClassNotFoundException, SQLException
    {
        boolean okunduMu=false;
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        String query="Select * from mesaj where alici=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, aliciNo);
        ResultSet rs=ps.executeQuery();
      
        if( rs.next())
        {
        Date gelen;
        String donecek;
        gelen=rs.getDate("gonderim_tarihi");
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        donecek=DATE_FORMAT.format(gelen);
        String okundu=rs.getString("okundu");
        if(okundu.equals("evet"))
            okunduMu=true;
      

        return new mesaj(
        String.valueOf(rs.getInt("mesajNo")),
        donecek,
        rs.getString("gonderici"),
        rs.getString("alici"),
        rs.getString("icerik"),
        okunduMu);
        }
        else
            return null;
        
        
    }
    
    public boolean mesajNosuVerilenMesajOkunmusMu(String mesajNo) throws ClassNotFoundException, SQLException
    {
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        String query="Select okundu from mesaj where mesajNo=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, mesajNo);
        ResultSet rs=ps.executeQuery();
        rs.next();
        if(rs.getString(1)=="evet")
            return true;
        else
            return false;
    }
    public void okunduEvetYap(String mesajNo) throws ClassNotFoundException, SQLException
    {
         baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        String query="Update mesaj set okundu='evet' where mesajNo=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, mesajNo);
        ps.executeUpdate();
      
    }
   
    
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
       // mesajIslemleriDb mid=new mesajIslemleriDb();
     
       
       
        
    }
    
}
