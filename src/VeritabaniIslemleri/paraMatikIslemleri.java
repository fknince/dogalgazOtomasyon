/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VeritabaniIslemleri;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;



import java.util.Date;
import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import paraMatik.paraMatik;

/**
 *
 * @author fince
 */
public class paraMatikIslemleri {

    public void islemGir(String islemTuru,int miktar,String paraId,String krediKartNo) throws ClassNotFoundException, SQLException
    {
        
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        String query="insert paramatik(islem_turu,miktar,paraId,krediKartNo) values(?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, islemTuru);
        ps.setInt(2, miktar);
        ps.setString(3, paraId);
        ps.setString(4, krediKartNo);
        ps.executeUpdate();
        

       
    }
    public paraMatik sonIslemiVer(String paraId) throws ClassNotFoundException, SQLException
    {
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        String query="select * from paramatik where paraId=? ORDER BY UNIX_TIMESTAMP(islem_tarihi) DESC;";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, paraId);
        ResultSet rs=ps.executeQuery();
        boolean onay=false;
        if(rs.next())
        {
             if(rs.getString("onay").equals("evet"))
            onay=true;
      
       
            String id=String.valueOf(rs.getInt("id"));
            Date islem_tarihi=rs.getDate("islem_tarihi");
            String islem_turu=rs.getString("islem_turu");
            int miktar=rs.getInt("miktar");
            String krediKartNo=rs.getString("krediKartNo");

            return new paraMatik(id, (java.sql.Date) islem_tarihi, islem_turu, onay, miktar, paraId, krediKartNo);
      
        }
        else
            return null;
       
        
    }
    
    public ObservableList<paraMatik> idYeGoreFaturalariVer(String id) throws ClassNotFoundException, SQLException
    {
        ObservableList<paraMatik> donecek=FXCollections.observableArrayList();
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        String query="Select * from paramatik where paraId=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1,id);
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            boolean onay=false;
            if(rs.getString("onay").equals("evet"))
                onay=true;
      
       
            String paraId=String.valueOf(rs.getInt("id"));
            Date islem_tarihi=rs.getDate("islem_tarihi");
            String islem_turu=rs.getString("islem_turu");
            int miktar=rs.getInt("miktar");
            String krediKartNo=rs.getString("krediKartNo");
            donecek.add(new paraMatik(paraId, (java.sql.Date) islem_tarihi, islem_turu, onay, miktar, paraId, krediKartNo));
        }
        return donecek;
        
    }
    public ObservableList<paraMatik> sadeceYuklemeİslemleriniVer(String id) throws ClassNotFoundException, SQLException
    {
        ObservableList<paraMatik> donecek=FXCollections.observableArrayList();
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        String query="Select * from paramatik where paraId=? and islem_turu='yukleme'";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1,id);
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            boolean onay=false;
            if(rs.getString("onay").equals("evet"))
                onay=true;
      
       
            String paraId=String.valueOf(rs.getInt("id"));
            Date islem_tarihi=rs.getDate("islem_tarihi");
            String islem_turu=rs.getString("islem_turu");
            int miktar=rs.getInt("miktar");
            String krediKartNo=rs.getString("krediKartNo");
            donecek.add(new paraMatik(paraId, (java.sql.Date) islem_tarihi, islem_turu, onay, miktar, paraId, krediKartNo));
        }
        return donecek;
    }
     public ObservableList<paraMatik> sadeceOdemeİslemleriniVer(String id) throws ClassNotFoundException, SQLException
    {
        ObservableList<paraMatik> donecek=FXCollections.observableArrayList();
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        String query="Select * from paramatik where paraId=? and islem_turu='odeme'";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1,id);
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            boolean onay=false;
            if(rs.getString("onay").equals("evet"))
                onay=true;
      
       
            String paraId=String.valueOf(rs.getInt("id"));
            Date islem_tarihi=rs.getDate("islem_tarihi");
            String islem_turu=rs.getString("islem_turu");
            int miktar=rs.getInt("miktar");
            String krediKartNo=rs.getString("krediKartNo");
            donecek.add(new paraMatik(paraId, (java.sql.Date) islem_tarihi, islem_turu, onay, miktar, paraId, krediKartNo));
        }
        return donecek;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
       // paraMatikIslemleri pmi=new paraMatikIslemleri();
       
        
    }
            
}
