/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abonePaneliIslemleri;

/**
 *
 * @author fince
 */
public class abone {
    String ad,soyad,kssno,sssno,telefon_No,daire_No,abonelik_Tarihi,apartNo;

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public String getKssno() {
        return kssno;
    }

    public String getSssno() {
        return sssno;
    }

    public String getTelefon_No() {
        return telefon_No;
    }

    public String getDaire_No() {
        return daire_No;
    }

    public String getAbonelik_Tarihi() {
        return abonelik_Tarihi;
    }

    public String getApartNo() {
        return apartNo;
    }

    public abone(String ad, String soyad, String kssno, String sssno, String telefon_No, String daire_No, String abonelik_Tarihi, String apartNo) {
        this.ad = ad;
        this.soyad = soyad;
        this.kssno = kssno;
        this.sssno = sssno;
        this.telefon_No = telefon_No;
        this.daire_No = daire_No;
        this.abonelik_Tarihi = abonelik_Tarihi;
        this.apartNo = apartNo;
    }
    
    
}
