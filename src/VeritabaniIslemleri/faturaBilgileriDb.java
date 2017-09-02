/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VeritabaniIslemleri;


import fatura.fatura;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author fince
 */
public class faturaBilgileriDb {
    public ObservableList<Integer> aboneyeAitFaturaIdleri(String aboneNo) throws ClassNotFoundException, SQLException
    {
        ObservableList<Integer> donecek=FXCollections.observableArrayList();
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        String query="Select faturaNo from abone_faturalari where aboneNo = ?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1,aboneNo);
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
          donecek.add(rs.getInt(1));
        }
        return donecek;
        
        
    }
    public ObservableList<fatura> seciliAboneninTumFaturalari(String aboneNo) throws ClassNotFoundException, SQLException
    {
        faturaBilgileriDb fdb=new faturaBilgileriDb();
        ObservableList<Integer> faturaIdleri=fdb.aboneyeAitFaturaIdleri(aboneNo);
        ObservableList<fatura> donecek=FXCollections.observableArrayList();
        

        
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        for(int i=0;i<faturaIdleri.size();i++)
        {
            String query="Select * from fatura where faturaNo=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, String.valueOf(faturaIdleri.get(i)));
            ResultSet rs=ps.executeQuery();
            rs.next();
            Date tarih;
            if(rs.getString("odenme_durumu").equals("evet"))
                tarih=rs.getDate("odenme_tarihi");
            else
                tarih=null;
                
            donecek.add(new fatura(
            String.valueOf(rs.getInt("faturaNo")),
            rs.getString("ay"),
            rs.getString("yil"),
            rs.getString("odenme_durumu"),
            rs.getFloat("fatura_bedeli"),
            rs.getFloat("istyg"),
            rs.getFloat("igtyt"),
            rs.getFloat("igssib"),
            rs.getFloat("igop"),
            rs.getFloat("opmbm"),
            rs.getFloat("opt"),
            rs.getFloat("bitt"),
            rs.getFloat("bitm"),
            rs.getFloat("sstft"),
            rs.getFloat("ssttt"),
            rs.getFloat("ssbm"),
            rs.getFloat("sosstft"),
            rs.getFloat("ssttm"),
            rs.getFloat("sosbm"),
            rs.getInt("daire_alani"),
            rs.getDate("son_odeme_tarihi"),
            tarih
                    
            ));
        }
        return donecek;
    }
    
    public int kacAdetOdenmemisFatura(String aboneNo) throws ClassNotFoundException, SQLException
    {
        int adet=0;
        faturaBilgileriDb fbd=new faturaBilgileriDb();
        ObservableList<fatura> gelen=fbd.seciliAboneninTumFaturalari(aboneNo);
        for(int i=0;i<gelen.size();i++)
        {
            if(gelen.get(i).getOdenmeDurumu().equals("hayir"))
                adet++;
        }
        return adet;
    }
    
    public fatura seciliFaturayaAitBilgiler(String faturaNo) throws ClassNotFoundException, SQLException{
    
            baglan b=new baglan();
            Connection con=b.veritabanina_Baglan();
            String query="Select * from fatura where faturaNo=?  ";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, faturaNo);
            ResultSet rs=ps.executeQuery();
            rs.next();
            Date tarih;
            if(rs.getString("odenme_durumu").equals("evet"))
            {
                tarih=rs.getDate("odenme_tarihi");
                
            }
            else
                tarih=null;
            
                
            return(new fatura(
            String.valueOf(rs.getInt("faturaNo")),
            rs.getString("ay"),
            rs.getString("yil"),
            rs.getString("odenme_durumu"),
            rs.getFloat("fatura_bedeli"),
            rs.getFloat("istyg"),
            rs.getFloat("igtyt"),
            rs.getFloat("igssib"),
            rs.getFloat("igop"),
            rs.getFloat("opmbm"),
            rs.getFloat("opt"),
            rs.getFloat("bitt"),
            rs.getFloat("bitm"),
            rs.getFloat("sstft"),
            rs.getFloat("ssttt"),
            rs.getFloat("ssbm"),
            rs.getFloat("sosstft"),
            rs.getFloat("ssttm"),
            rs.getFloat("sosbm"),
            rs.getInt("daire_alani"),
            rs.getDate("son_odeme_tarihi"),
            tarih));
                    
    }
    public void faturaOdendi(String faturaNo) throws ClassNotFoundException, SQLException
    {
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        String query="Update fatura set odenme_durumu='evet' ,odenme_tarihi=now() where faturaNo=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, faturaNo);
        ps.executeUpdate();
        
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        //faturaBilgileriDb fbd=new faturaBilgileriDb();
 
       
       
    }
}
