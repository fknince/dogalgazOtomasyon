/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krediKartiAlgoritmalari;

/**
 *
 * @author fince
 */
public class krediKartiAlgoritmalari 
{
        
        public boolean krediKartiGecerliMi(String krediKartNo)
        {
            boolean sonuc=false;
            String[] dizi=krediKartNo.split("-");
            int tekToplam=0;
            int ciftToplam=0;
            for(String s:dizi)
            {
                for(int i=0;i<s.length();i++)
                {
                  
                    if((i+1) %2 == 0)
                    {
                        ciftToplam+=Character.getNumericValue(s.charAt(i));
                    }
                    else
                    {
                        tekToplam+=(Character.getNumericValue(s.charAt(i))*2);
                    }
                }
            }
           if((tekToplam+ciftToplam) % 10 == 0 )
           {
               sonuc=true;
           }
           return sonuc;
        }

    
}
