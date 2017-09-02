/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mesaj;

/**
 *
 * @author fince
 */
public class mesaj {
    String mesajNo,gonderimTarihi,gondericiNo,aliciNo,icerik;
    boolean okundu;

    public String getMesajNo() {
        return mesajNo;
    }

    public String getGonderimTarihi() {
        return gonderimTarihi;
    }

    public String getGondericiNo() {
        return gondericiNo;
    }

    public String getAliciNo() {
        return aliciNo;
    }

    public String getIcerik() {
        return icerik;
    }

    public boolean isOkundu() {
        return okundu;
    }

    public mesaj(String mesajNo, String gonderimTarihi, String gondericiNo, String aliciNo, String icerik, boolean okundu) {
        this.mesajNo = mesajNo;
        this.gonderimTarihi = gonderimTarihi;
        this.gondericiNo = gondericiNo;
        this.aliciNo = aliciNo;
        this.icerik = icerik;
        this.okundu = okundu;
    }
}
