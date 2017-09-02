/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatura;

import java.sql.Date;

/**
 *
 * @author fince
 */
public class fatura {
    private String faturaNo,Ay,Yil,odenmeDurumu;
    private float fatura_Bedeli,istyg,igtyt,igssib,igop,opmbm,opt,bitt,bitm,sstft,ssttt,ssbm,sosstft,ssttm
            ,sosbm;
    private int daire_alani;
    Date son_odemeTar,odenmeTar;

    public String getFaturaNo() {
        return faturaNo;
    }

    public String getAy() {
        return Ay;
    }

    public String getYil() {
        return Yil;
    }

    public String getOdenmeDurumu() {
        return odenmeDurumu;
    }

    public float getFatura_Bedeli() {
        return fatura_Bedeli;
    }

    public float getIstyg() {
        return istyg;
    }

    public float getIgtyt() {
        return igtyt;
    }

    public float getIgssib() {
        return igssib;
    }

    public float getIgop() {
        return igop;
    }

    public float getOpmbm() {
        return opmbm;
    }

    public float getOpt() {
        return opt;
    }

    public float getBitt() {
        return bitt;
    }

    public float getBitm() {
        return bitm;
    }

    public float getSstft() {
        return sstft;
    }

    public float getSsttt() {
        return ssttt;
    }

    public float getSsbm() {
        return ssbm;
    }

    public float getSosstft() {
        return sosstft;
    }

    public float getSsttm() {
        return ssttm;
    }

    public float getSosbm() {
        return sosbm;
    }

    public int getDaire_alani() {
        return daire_alani;
    }

    public Date getSon_odemeTar() {
        return son_odemeTar;
    }

    public Date getOdenmeTar() {
        return odenmeTar;
    }
            
   

    public fatura(String faturaNo, String Ay, String Yil, String odenmeDurumu, float fatura_Bedeli, float istyg, float igtyt, float igssib, float igop, float opmbm, float opt, float bitt, float bitm, float sstft, float ssttt, float ssbm, float sosstft, float ssttm, float sosbm, int daire_alani, Date son_odemeTar, Date odenmeTar) {
        this.faturaNo = faturaNo;
        this.Ay = Ay;
        this.Yil = Yil;
        this.odenmeDurumu = odenmeDurumu;
        this.fatura_Bedeli = fatura_Bedeli;
        this.istyg = istyg;
        this.igtyt = igtyt;
        this.igssib = igssib;
        this.igop = igop;
        this.opmbm = opmbm;
        this.opt = opt;
        this.bitt = bitt;
        this.bitm = bitm;
        this.sstft = sstft;
        this.ssttt = ssttt;
        this.ssbm = ssbm;
        this.sosstft = sosstft;
        this.ssttm = ssttm;
        this.sosbm = sosbm;
        this.daire_alani = daire_alani;
        this.son_odemeTar = son_odemeTar;
        this.odenmeTar = odenmeTar;
    }
   
    
}
