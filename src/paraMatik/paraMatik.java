package paraMatik;


import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fince
 */
public class paraMatik {
    private Date islemTarihi;
    private String islemTuru;
    private boolean onay;
    private String id;
    private int miktar;
    private String paraId;
    private String krediKartNo;

    public String getKrediKartNo() {
        return krediKartNo;
    }

    public void setKrediKartNo(String krediKartNo) {
        this.krediKartNo = krediKartNo;
    }

    public String getParaId() {
        return paraId;
    }

    public void setParaId(String paraId) {
        this.paraId = paraId;
    }

    public paraMatik(String id,Date islemTarihi, String islemTuru, boolean onay,int miktar,String paraId,String krediKartNo) {
        this.islemTarihi = islemTarihi;
        this.islemTuru = islemTuru;
        this.onay = onay;
        this.id = id;
        this.miktar=miktar;
        this.paraId=paraId;
        this.krediKartNo=krediKartNo;
    }
  

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public Date getIslemTarihi() {
        return islemTarihi;
    }

    public String getIslemTuru() {
        return islemTuru;
    }

    public boolean isOnay() {
        return onay;
    }

    public String getId() {
        return id;
    }

    public void setIslemTarihi(Date islemTarihi) {
        this.islemTarihi = islemTarihi;
    }

    public void setIslemTuru(String islemTuru) {
        this.islemTuru = islemTuru;
    }

    public void setOnay(boolean onay) {
        this.onay = onay;
    }
}
