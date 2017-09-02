/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginKontrolIslemleri;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author fince
 */
public class MD5_encoder {
    public String string2MD5(String sifre) throws NoSuchAlgorithmException
    {
    	String password = sifre;

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

         return sb.toString();

        
    }
    public static void main(String[] args) throws NoSuchAlgorithmException
    {
        MD5_encoder me=new MD5_encoder();
        System.out.println(me.string2MD5("sezen1234"));
    }

    
}
