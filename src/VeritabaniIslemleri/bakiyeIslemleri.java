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

/**
 *
 * @author fince
 */
public class bakiyeIslemleri {
    
    public String bakiyeVer(String aboneNo) throws ClassNotFoundException, SQLException
    {
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        String query=("Select para from para where aboneNo=?");
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, aboneNo);
        ResultSet rs=ps.executeQuery();
        rs.next();
        String donecek=String.valueOf(rs.getInt("para"))+" TL";
        return donecek;
        
        
    }
    public String idVer(String aboneNo) throws ClassNotFoundException, SQLException
    {
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        String query=("Select id from para where aboneNo=?");
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, aboneNo);
        ResultSet rs=ps.executeQuery();
        rs.next();
        return String.valueOf(rs.getInt("id"));
    }
    
    public void bakiyeArtir(int miktar,String aboneNo) throws ClassNotFoundException, SQLException
    {
        bakiyeIslemleri bi=new bakiyeIslemleri();
        String[] gelen=bi.bakiyeVer(aboneNo).split(" ");
        int bakiye=Integer.parseInt(gelen[0]);
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        String query="Update para set para=? where aboneNo = ?";
        PreparedStatement ps=con.prepareStatement(query);
        int eklenecek=bakiye+miktar;
        ps.setInt(1, eklenecek);
        ps.setString(2, aboneNo);
        ps.executeUpdate();
        
    }
    public void bakiyeAzalt(int miktar,String aboneNo) throws ClassNotFoundException, SQLException
    {
        bakiyeIslemleri bi=new bakiyeIslemleri();
        String[] gelen=bi.bakiyeVer(aboneNo).split(" ");
        int bakiye=Integer.parseInt(gelen[0]);
        baglan b=new baglan();
        Connection con=b.veritabanina_Baglan();
        String query="Update para set para=? where aboneNo = ?";
        PreparedStatement ps=con.prepareStatement(query);
        int eklenecek=bakiye-miktar;
        ps.setInt(1, eklenecek);
        ps.setString(2, aboneNo);
        ps.executeUpdate();
        
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
       //bakiyeIslemleri bi=new bakiyeIslemleri();
   
       
    }
}
