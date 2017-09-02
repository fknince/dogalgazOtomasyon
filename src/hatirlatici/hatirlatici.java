/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hatirlatici;

import java.sql.Date;

/**
 *
 * @author fince
 */
public class hatirlatici {
    private String hatNo,baslik;
    private Date hatirlatmaTarihi;

    public String getHatNo() {
        return hatNo;
    }

    public void setHatNo(String hatNo) {
        this.hatNo = hatNo;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public Date getHatirlatmaTarihi() {
        return hatirlatmaTarihi;
    }

    public void setHatirlatmaTarihi(Date hatirlatmaTarihi) {
        this.hatirlatmaTarihi = hatirlatmaTarihi;
    }

    public hatirlatici(String hatNo, String baslik, Date hatirlatmaTarihi) {
        this.hatNo = hatNo;
        this.baslik = baslik;
        this.hatirlatmaTarihi = hatirlatmaTarihi;
    }
    
}
