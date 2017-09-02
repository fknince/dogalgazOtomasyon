/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abonePaneliIslemleri;

import VeritabaniIslemleri.aboneBilgileriDb;
import VeritabaniIslemleri.aboneLoginDb;
import VeritabaniIslemleri.apartmanIslemleriDb;
import VeritabaniIslemleri.bakiyeIslemleri;
import VeritabaniIslemleri.faturaBilgileriDb;
import VeritabaniIslemleri.login2Panel;
import VeritabaniIslemleri.mesajIslemleriDb;
import VeritabaniIslemleri.paraMatikIslemleri;

import apartman.apartman;
import detayVerPaneli.DetayVerController;
import eMailGonderici.SendEmail;
import fatura.fatura;
import hatirlatici.hatirlatici;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;

import javafx.animation.KeyFrame;

import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import javafx.util.Duration;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import javax.xml.bind.Marshaller;

import kiyasPaneli.İkiFaturaKiyasController;
import krediKartiAlgoritmalari.krediKartiAlgoritmalari;
import mesaj.mesaj;
import mesajDetay.MesajDetayiController;
import paraMatik.paraMatik;
import yuklemeOnayPenceresi.YuklemeOnayPenceresiController;


/**
 * FXML Controller class
 *
 * @author fince
 */
public class AbonePaneliController implements Initializable {

    @FXML
    private TextField txt_ad;
    @FXML
    private TextField txt_soyad;
    @FXML
    private TextField txt_telefonNo;
    @FXML
    private TextField txt_sssno;
    @FXML
    private TextField txt_kssno;
    @FXML
    private TextField txt_kayitTarihi;
    @FXML
    private TextField txt_apNo;
    @FXML
    private TextField txt_daireNo;
    @FXML
    private TextField txt_adres;
    @FXML
    private ToggleButton btn_bilgiDegistir;
    @FXML
    private Button btn_kaydet;
    @FXML
    private Button btn_sifirla;
    @FXML
    private ImageView img_resim;
    @FXML
    private Label lbl_sonGirisTarihi;
    @FXML
    private Label lbl_mesajAdet;
    @FXML
    private ImageView img_faturaResim;
    @FXML
    private Label lbl_odenmemisFatura;
    @FXML
    private Label lbl_bilgi;
    @FXML
    private Button btn_bilgilerim;
    @FXML
    private Button btn_faturalarim;
    @FXML
    private Button btn_grafiklerim;
    @FXML
    private Button btn_mesajlarim;
    @FXML
    private Button btn_paraMatik;
    @FXML
    private TabPane tabPane_genel;
    @FXML
    private ImageView img_faturalarim;
    @FXML
    private Tab pane1;
    @FXML
    private Tab pane2;
    @FXML
    private Tab pane3;
    @FXML
    private Tab pane4;
    @FXML
    private Tab pane5;

    @FXML
    private Label lbl_mesajUst;
    @FXML
    private TableView<fatura> table_faturalar;
    @FXML
    private TableColumn<fatura, String> TableColumn_faturaNo;
    @FXML
    private TableColumn<fatura, String> TableColumn_yil;
    @FXML
    private TableColumn<fatura, String> TableColumn_ay;
    @FXML
    private TableColumn<fatura, Date> TableColumn_sonOdeme;
    @FXML
    private TableColumn<fatura, Float> TableColumn_faturaBedeli;
    @FXML
    private TableColumn<fatura, String> TableColumn_odenmeDurumu;
    @FXML
    private Button btn_odemeYap;
    private boolean pass=true;
    private boolean pass_fatuGrafik=true;
    private boolean pass_ParaMatik=true;
    private boolean yukleMe=true;
    @FXML
    private ComboBox<Integer> cmb_fatura1;
    @FXML
    private ComboBox<Integer> cmb_fatura2;
    @FXML
    private Button btn_kiyasla;
    @FXML
    private Button btn_detayVer;
    
    private boolean detayAcikMi=true;
    private boolean kiyasAcikMi=true;
    private boolean mesajDetayAcikMi=true;
   
    @FXML
    private BarChart<String, Number> barChart_1;
    @FXML
    private ComboBox<String> cmb_kriterler;
    @FXML
    private NumberAxis axisY_degerler;
    @FXML
    private CategoryAxis axisX_aylar;
     private ObservableList<String> kriterList =FXCollections.observableArrayList(
            "Toplam Fatura Bedeli","Isınma İçin Yapılan Harcama","Su Isıtma İçin Yapılan Harcama","Isınma İçin Kullanılan kWh",
               "Harcanan Sıcak Su");
    @FXML
    private TableView<mesaj> tb_mesaj;
    @FXML
    private TableColumn<mesaj, String> tableColumn_mesajNo;
    @FXML
    private TableColumn<mesaj, String> tableColumn_gonderimTar;
    @FXML
    private TableColumn<mesaj, String> tableColumn_gonderen;
    @FXML
    private TableColumn<mesaj, String> tableColumn_icerik;
    
    private   ScaleTransition st;
    @FXML
    private Accordion acPane_genel;
    @FXML
    private TitledPane acPane_paraYukleme;
    @FXML
    private ImageView sliderTutar;
    @FXML
    private TextField txt_sliderDeger;
    @FXML
    private Label lbl_slider;
    @FXML
    private TextField txt_krediKartNo;
    @FXML
    private ImageView img_sirket;
    private TextField lbl_sonKullanmaTarihi;
    @FXML
    private Button btn_yukle;
    @FXML
    private TitledPane acPane_islemOzeti;
    @FXML
    private Slider slider_1;
    @FXML
    private TextField txt_sonKullanmaTarihi;
    @FXML
    private TextField txt_guvenlikKodu;
    @FXML
    private Label lbl_bakiye;
    @FXML
    private Button btn_emailYolla;
    
    private paraMatik sonIslem;
  
    @FXML
    private TextField txt_emailAdresi;
    
    private boolean yukleOnay=true;
    
    public  YuklemeOnayPenceresiController controller;
    @FXML
    private AnchorPane ana_pane;
    
    public int sayac=0;
    @FXML
    private TableView<paraMatik> tb_islemOzeti;
    @FXML
    private TableColumn<paraMatik, String> column_islemId;
    @FXML
    private ComboBox<String> cmb_islemTuru;
    @FXML
    private TableColumn<paraMatik, String> column_islemTarihi;
    @FXML
    private TableColumn<paraMatik, String> column_islem;
    @FXML
    private TableColumn<paraMatik, Integer> column_miktar;
    @FXML
    private TableColumn<paraMatik, String> column_krediKartNo;
     private ObservableList<String> islemTuruList =FXCollections.observableArrayList(
            "Hepsi","Yükleme","Ödeme");
     private boolean emailHataKontrol = false;
   
     
   
    
   
 
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //table view columnları resizable false yapma
        TableColumn_ay.setResizable(false);
        TableColumn_faturaBedeli.setResizable(false);
        TableColumn_faturaNo.setResizable(false);
        TableColumn_odenmeDurumu.setResizable(false);
        TableColumn_sonOdeme.setResizable(false);
        TableColumn_yil.setResizable(false);
        
        tableColumn_gonderen.setResizable(false);
        tableColumn_gonderimTar.setResizable(false);
        tableColumn_icerik.setResizable(false);
        tableColumn_mesajNo.setResizable(false);
       
        //stage kapanınca yapılacaklar
        aboneLoginDb ald=new aboneLoginDb();
        login2Panel l2p=new login2Panel();
        aboneBilgileriDb abd=new aboneBilgileriDb();
        apartmanIslemleriDb aid=new apartmanIslemleriDb();
        mesajIslemleriDb mid=new mesajIslemleriDb();
      
        //kriter combo boz içini doldurma
        cmb_kriterler.setItems(kriterList);
        
        lbl_bilgi.setText("");
        txt_ad.setEditable(false);
        txt_soyad.setEditable(false);
        txt_telefonNo.setEditable(false);
        txt_kayitTarihi.setEditable(false);
        txt_kssno.setEditable(false);
        txt_sssno.setEditable(false);
        txt_apNo.setEditable(false);
        txt_daireNo.setEditable(false);
        txt_adres.setEditable(false);
      
        try {
            //son giriş tarihi
            lbl_sonGirisTarihi.setText(ald.sonGirisTarihi(l2p.uyeNo_ver()));
            //abone(Database) bilgileri
            abone kisi=abd.seciliAboneyiVer(l2p.uyeNo_ver());
            txt_ad.setText(kisi.getAd());
            txt_soyad.setText(kisi.getSoyad());
            txt_telefonNo.setText(kisi.getTelefon_No());
            txt_kayitTarihi.setText(kisi.getAbonelik_Tarihi());
            txt_kssno.setText(kisi.getKssno());
            txt_sssno.setText(kisi.getSssno());
            txt_daireNo.setText(kisi.getDaire_No());
            //apartman(Database) bilgileri
            apartman apart=aid.seciliApartmaniVer(kisi.getApartNo());
            txt_apNo.setText(apart.getApartAdi());
            txt_adres.setText(apart.getAdres());
            
            //mesaj animasyon
            st=new ScaleTransition(Duration.millis(2000),lbl_mesajUst);
            st.setByX(1.5f);
            st.setByY(1.5f);
            st.setCycleCount(Timeline.INDEFINITE);
            st.setAutoReverse(true);
            
            okunmamisMesaj();
            
            
              
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AbonePaneliController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AbonePaneliController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //combo box item change listener
        cmb_kriterler.valueProperty().addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
                login2Panel l2p=new login2Panel();
                try {
                    grafikCiz(l2p.uyeNo_ver(), cmb_kriterler.getSelectionModel().getSelectedItem());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AbonePaneliController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AbonePaneliController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        //bakiye kısmı
        bakiyeIslemleri bi=new bakiyeIslemleri();
        try {
            lbl_bakiye.setText(bi.bakiyeVer(l2p.uyeNo_ver()));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AbonePaneliController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AbonePaneliController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         //işem türü combo box  change listener
        cmb_islemTuru.setItems(islemTuruList);
        cmb_islemTuru.valueProperty().addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
               if(newValue.equals("Hepsi"))
                {
                    tb_islemOzeti.getItems().clear();
                     //işlem özetini doldur
                    try
                    {
                        paraMatikIslemleri pi=new paraMatikIslemleri();
                        login2Panel l2p=new login2Panel();
                        bakiyeIslemleri bi=new bakiyeIslemleri();
                        String id=bi.idVer(l2p.uyeNo_ver());
                        ObservableList<paraMatik> gelen=pi.idYeGoreFaturalariVer(id);
                        if(gelen != null)
                        {
                            column_islemId.setCellValueFactory(new PropertyValueFactory<paraMatik,String>("id"));
                            column_islemTarihi.setCellValueFactory(new PropertyValueFactory<paraMatik,String>("islemTarihi"));
                            column_islem.setCellValueFactory(new PropertyValueFactory<paraMatik,String>("islemTuru"));
                            column_miktar.setCellValueFactory(new PropertyValueFactory<paraMatik,Integer>("miktar"));
                            column_krediKartNo.setCellValueFactory(new PropertyValueFactory<paraMatik,String>("krediKartNo"));

                            tb_islemOzeti.setItems(gelen);
                        }
                    }
                    catch(Exception e)
                    {
                    
                    }
                   
                }
               else if(newValue.equals("Yükleme"))
                {
                    tb_islemOzeti.getItems().clear();
                     //işlem özetini doldur
                    try
                    {
                        paraMatikIslemleri pi=new paraMatikIslemleri();
                        login2Panel l2p=new login2Panel();
                        bakiyeIslemleri bi=new bakiyeIslemleri();
                        String id=bi.idVer(l2p.uyeNo_ver());
                        ObservableList<paraMatik> gelen=pi.sadeceYuklemeİslemleriniVer(id);
                        if(gelen != null)
                        {
                            column_islemId.setCellValueFactory(new PropertyValueFactory<paraMatik,String>("id"));
                            column_islemTarihi.setCellValueFactory(new PropertyValueFactory<paraMatik,String>("islemTarihi"));
                            column_islem.setCellValueFactory(new PropertyValueFactory<paraMatik,String>("islemTuru"));
                            column_miktar.setCellValueFactory(new PropertyValueFactory<paraMatik,Integer>("miktar"));
                            column_krediKartNo.setCellValueFactory(new PropertyValueFactory<paraMatik,String>("krediKartNo"));

                            tb_islemOzeti.setItems(gelen);
                        }
                    }
                    catch(Exception e)
                    {
                    
                    }
                }
               else if(newValue.equals("Ödeme"))
                {
                    tb_islemOzeti.getItems().clear();
                     //işlem özetini doldur
                    try
                    {
                        paraMatikIslemleri pi=new paraMatikIslemleri();
                        login2Panel l2p=new login2Panel();
                        bakiyeIslemleri bi=new bakiyeIslemleri();
                        String id=bi.idVer(l2p.uyeNo_ver());
                        ObservableList<paraMatik> gelen=pi.sadeceOdemeİslemleriniVer(id);
                        if(gelen != null)
                        {
                            column_islemId.setCellValueFactory(new PropertyValueFactory<paraMatik,String>("id"));
                            column_islemTarihi.setCellValueFactory(new PropertyValueFactory<paraMatik,String>("islemTarihi"));
                            column_islem.setCellValueFactory(new PropertyValueFactory<paraMatik,String>("islemTuru"));
                            column_miktar.setCellValueFactory(new PropertyValueFactory<paraMatik,Integer>("miktar"));
                            column_krediKartNo.setCellValueFactory(new PropertyValueFactory<paraMatik,String>("krediKartNo"));

                            tb_islemOzeti.setItems(gelen);
                        }
                    }
                    catch(Exception e)
                    {
                    
                    }
                }
            }
        });
   
    }    

    @FXML
    private void bilgiDegistir_basildi(ActionEvent event) throws InterruptedException {
        if(btn_bilgiDegistir.isSelected())
        {
            bilgiDegisimineIzinVer();      
        }
        else
        {
            bilgiDegisiminiEngelle();
        }
    }
    
    
    @FXML
    private void kaydet_basildi(ActionEvent event) throws ClassNotFoundException, SQLException {
        int sonuc=JOptionPane.showConfirmDialog(null, "Yaptığınız değişikliği onaylıyor musunuz ?");
        if(sonuc == 0)
        {
            aboneBilgileriDb abd=new aboneBilgileriDb();
            login2Panel l2p=new login2Panel();
            boolean donen=abd.aboneBilgileriGuncelle(l2p.uyeNo_ver(), txt_ad.getText(), txt_soyad.getText(),
                    txt_telefonNo.getText());
            if(donen)
                JOptionPane.showMessageDialog(null, "Bilgileriniz başarıyla güncellendi.","Bilgilendirme",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @FXML
    private void sifirla_basildi(ActionEvent event) throws ClassNotFoundException, SQLException {
            aboneBilgileriDb abd=new aboneBilgileriDb();
            login2Panel l2p=new login2Panel();
            abone kisi=abd.seciliAboneyiVer(l2p.uyeNo_ver());
            
            txt_ad.setEditable(false);
            txt_soyad.setEditable(false);
            txt_telefonNo.setEditable(false);
            
            txt_ad.setText(kisi.getAd());
            txt_soyad.setText(kisi.getSoyad());
            txt_telefonNo.setText(kisi.getTelefon_No());
            lbl_bilgi.setText("Ad,Soyad ve Telefon No bilgileriniz sıfırlandı.");
    }

    @FXML
    private void bilgilerim_Basildi(ActionEvent event) throws ClassNotFoundException, SQLException {
       paneleriDisableYap();
       pane1.setDisable(false);
       tabPane_genel.getSelectionModel().select(0);
       
       okunmamisMesaj();
            
    }
    

    @FXML
    private void faturalarim_Basildi(ActionEvent event) throws ClassNotFoundException, SQLException {
       paneleriDisableYap();
       pane2.setDisable(false);
       tabPane_genel.getSelectionModel().select(1);
       
       okunmamisMesaj();
            
    }

    @FXML
    private void grafiklerim_Basildi(ActionEvent event) throws ClassNotFoundException, SQLException {
       paneleriDisableYap();
       pane3.setDisable(false);
       tabPane_genel.getSelectionModel().select(2);
       
        okunmamisMesaj();
            
    }

    @FXML
    private void mesajlarim_Basildi(ActionEvent event) throws SQLException, ClassNotFoundException {
       paneleriDisableYap();
       pane4.setDisable(false);
       tabPane_genel.getSelectionModel().select(3);
       
       okunmamisMesaj();
            
    }

   
    
    
    @FXML
    private void paraMatik_Basildi(ActionEvent event) {
       paneleriDisableYap();
       pane5.setDisable(false);
       tabPane_genel.getSelectionModel().select(4);
    }
    
    public void paneleriDisableYap()
    {
        pane1.setDisable(true);
        pane2.setDisable(true);
        pane3.setDisable(true);
        pane4.setDisable(true);
        pane5.setDisable(true);
       
        
    }
    public void bilgiDegisimineIzinVer()
    {
        lbl_bilgi.setText("Ad,Soyad Telefon No bilgilerinizi artık değiştirebilirsiniz.");
        txt_ad.setEditable(true);
        txt_soyad.setEditable(true);
        txt_telefonNo.setEditable(true);
        
    }
    public void bilgiDegisiminiEngelle()
    {
        lbl_bilgi.setText("");
        txt_ad.setEditable(false);
        txt_soyad.setEditable(false);
        txt_telefonNo.setEditable(false);
    }
    
    public void okunmamisMesaj() throws ClassNotFoundException, SQLException
    {
        //okunmamış mesaj sayısı
            mesajIslemleriDb mid=new mesajIslemleriDb();
            login2Panel l2p=new login2Panel();
            int adet=mid.aboninOkunmayanMesajiVarMi(l2p.uyeNo_ver());
            lbl_mesajAdet.setText(String.valueOf(adet));
            if(adet > 0)
            {
                lbl_mesajUst.setText(String.valueOf(adet));
                st.play();
            }
            else
            {
                 lbl_mesajUst.setText("");
                 st.stop();
            }
    }

    @FXML
    private void bilgilerime_GecisYapildi(Event event) throws ClassNotFoundException, SQLException {
        //eğer bilgilerim paneline geçiş yapıldı ise mesaj gibi bilgileri güncele
        if(pane1.isSelected())
        {
            //odenmemis fatura var mi bak
            faturaBilgileriDb fdb=new faturaBilgileriDb();
            login2Panel l2p=new login2Panel();
            int adet=fdb.kacAdetOdenmemisFatura(l2p.uyeNo_ver());
            lbl_odenmemisFatura.setText(String.valueOf(adet));
            if(adet != 0)
                img_faturaResim.setImage(new Image("/resimler/no.png"));
            else
                img_faturaResim.setImage(new Image("/resimler/yes.png"));

            
        }
        else
        {
            bilgiDegisiminiEngelle();
        }
    }

    @FXML
    private void faturalarima_gecisYapildi(Event event) throws ClassNotFoundException, SQLException {
            if(pane2.isSelected())
            {
                //ilk geçiş ise
                if(pass)
                {
                    login2Panel l2p=new login2Panel();
                    faturaBilgileriDb fbd=new faturaBilgileriDb();
                    ObservableList<fatura> gelen=fbd.seciliAboneninTumFaturalari(l2p.uyeNo_ver());

                    TableColumn_faturaNo.setCellValueFactory(new PropertyValueFactory<fatura,String>("faturaNo"));
                    TableColumn_yil.setCellValueFactory(new PropertyValueFactory<fatura,String>("Yil"));
                    TableColumn_ay.setCellValueFactory(new PropertyValueFactory<fatura,String>("Ay"));
                    TableColumn_sonOdeme.setCellValueFactory(new PropertyValueFactory<fatura,Date>("son_odemeTar"));
                    TableColumn_faturaBedeli.setCellValueFactory(new PropertyValueFactory<fatura,Float>("fatura_Bedeli"));
                    TableColumn_odenmeDurumu.setCellValueFactory(new PropertyValueFactory<fatura,String>("odenmeDurumu"));
                    
                    

                    table_faturalar.setItems(gelen);

                    //tabloda seçilen satırı dinleme
                    table_faturalar.getSelectionModel().selectedItemProperty().addListener(listener);
                    pass=false;
                       try {
                            //combo boxları doldurma
                            ObservableList<Integer> listem=fbd.aboneyeAitFaturaIdleri(l2p.uyeNo_ver());
                            cmb_fatura1.setItems(listem);
                            cmb_fatura2.setItems(listem);
                            
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(AbonePaneliController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(AbonePaneliController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                       
                       
                }
              
           
                
                    
            }
    }


    @FXML
    private void odemeYapTiklandi(ActionEvent event) throws ClassNotFoundException, SQLException {
        login2Panel l2p=new login2Panel();
        bakiyeIslemleri bi=new bakiyeIslemleri();
        paraMatikIslemleri pi=new paraMatikIslemleri();
        String gelenBakiye=bi.bakiyeVer(l2p.uyeNo_ver());
        faturaBilgileriDb fdb=new faturaBilgileriDb();
        try
        {
            String[] parcala =gelenBakiye.split(" ");
        int bakiye=Integer.parseInt(parcala[0]);
        float faturaTutari=table_faturalar.getSelectionModel().getSelectedItem().getFatura_Bedeli();
        if(bakiye < faturaTutari)
        {
            int sonuc=JOptionPane.showConfirmDialog(null, "Ödeme yapmak için yeterli bakiyeniz yok.\n"
                    + "Yükleme yapmak için 'YES' tuşuna basınız","Dikkat",JOptionPane.YES_NO_OPTION);
            if(sonuc == JOptionPane.YES_OPTION)
            {
                paraMatik_Basildi(event);
                acPane_genel.setExpandedPane(acPane_paraYukleme);
                
            }
        }
        else
        {
            String id=l2p.uyeNo_ver();
            paraMatik gelen=pi.sonIslemiVer(id);
            String krediKartNo;
            if(gelen == null)
                krediKartNo=null;
            else
            {
              krediKartNo=gelen.getKrediKartNo();
            }
               
            int sayi=(int)faturaTutari;
            pi.islemGir("odeme",sayi,bi.idVer(id),krediKartNo);
            bi.bakiyeAzalt(sayi, id);
            bakiyeAnimasyon();
            fdb.faturaOdendi(table_faturalar.getSelectionModel().getSelectedItem().getFaturaNo());
            table_faturalar.itemsProperty().unbind();
            table_faturalar.getItems().clear();
            ObservableList<fatura> liste=fdb.seciliAboneninTumFaturalari(l2p.uyeNo_ver());

                    TableColumn_faturaNo.setCellValueFactory(new PropertyValueFactory<fatura,String>("faturaNo"));
                    TableColumn_yil.setCellValueFactory(new PropertyValueFactory<fatura,String>("Yil"));
                    TableColumn_ay.setCellValueFactory(new PropertyValueFactory<fatura,String>("Ay"));
                    TableColumn_sonOdeme.setCellValueFactory(new PropertyValueFactory<fatura,Date>("son_odemeTar"));
                    TableColumn_faturaBedeli.setCellValueFactory(new PropertyValueFactory<fatura,Float>("fatura_Bedeli"));
                    TableColumn_odenmeDurumu.setCellValueFactory(new PropertyValueFactory<fatura,String>("odenmeDurumu"));
                    
                    

                    table_faturalar.setItems(liste);
            
            
        }
        }
        catch(Exception e)
        {
            
        }
        
        
    }

  

    @FXML
    private void kiyaslaBasildi(ActionEvent event) 
    {
        if(cmb_fatura1.getSelectionModel().getSelectedItem() == null &&
                cmb_fatura2.getSelectionModel().getSelectedItem() == null)
        {
             JOptionPane.showMessageDialog(null, "Fatura No'larını seçmediniz.","Dikkat!",
                        JOptionPane.ERROR_MESSAGE);
        }
        else if(cmb_fatura1.getSelectionModel().getSelectedItem() == null)
        {
             JOptionPane.showMessageDialog(null, "1. Fatura No'yu seçiniz.","Dikkat!",
                        JOptionPane.ERROR_MESSAGE);
        }
        else if(cmb_fatura2.getSelectionModel().getSelectedItem() == null)
        {
             JOptionPane.showMessageDialog(null, "2. Fatura No'yu seçiniz.","Dikkat!",
                        JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            if(cmb_fatura1.getSelectionModel().getSelectedItem() == cmb_fatura2.getSelectionModel().getSelectedItem())
            {
                JOptionPane.showMessageDialog(null, "Bence 2 aynı şeyi karşılaştırmak saçma olur :)","Dikkat!",
                        JOptionPane.ERROR_MESSAGE);
                
            }
            else
            {
                if(kiyasAcikMi)
                {
                 try {
                 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/kiyasPaneli/ikiFaturaKiyas.fxml"));
                     Parent root1 = (Parent) fxmlLoader.load();
                     Stage stage=new Stage();
                     stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                     @Override
                     public void handle(WindowEvent event) {
                        kiyasAcikMi=true;
                     }
                 });
                     stage.setScene(new Scene(root1));  
                     İkiFaturaKiyasController controller=fxmlLoader.getController();
                     
                    controller.yazdir(cmb_fatura1.getSelectionModel().getSelectedItem(), 
                            cmb_fatura2.getSelectionModel().getSelectedItem());
                     
                     kiyasAcikMi=false;
                     stage.show();
             } catch(Exception e) {
                e.printStackTrace();
               }
                }
         
            }
        
          
    }

 


    }

    @FXML
    private void detayVerBasildi(ActionEvent event) {
        if(detayAcikMi)
        {
         try {
                 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/detayVerPaneli/detayVer.fxml"));
                     Parent root1 = (Parent) fxmlLoader.load();
                     Stage stage=new Stage();
                     DetayVerController controller=fxmlLoader.getController();
                     stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                     @Override
                     public void handle(WindowEvent event) {
                         detayAcikMi=true;
                     }
                 });
                     stage.setScene(new Scene(root1));  
                    
                     
                    controller.yazdir(table_faturalar.getSelectionModel().getSelectedItem().getFaturaNo());
                    controller.setStage(stage);
                    detayAcikMi=false;
                     
                     stage.show();
             } catch(Exception e) {
                e.printStackTrace();
               }
        }
    }

    @FXML
    private void faturaGrafiklerime_gecisYapildi(Event event) throws ClassNotFoundException, SQLException {
        if(pane3.isSelected())
        {
            //ilk giriş
            if(pass_fatuGrafik)
            {
                cmb_kriterler.getSelectionModel().selectFirst();
                pass_fatuGrafik=false;
            }
            
        }
    }
    
    public void grafikCiz(String aboneNo,String kriter) throws ClassNotFoundException, SQLException
    {
        switch(kriter)
        {
            case "Toplam Fatura Bedeli":
            {
            barChart_1.getData().clear();
            barChart_1.setTitle("Aylık Fatura Bedeli Grafiğiniz");
            axisX_aylar.setLabel("Aylar");
            axisY_degerler.setLabel("TL");
            
           XYChart.Series seri_1 =new XYChart.Series<>();
           seri_1.setName("2017");
           
           faturaBilgileriDb fdb=new faturaBilgileriDb();
           ObservableList<fatura> faturalar=fdb.seciliAboneninTumFaturalari(aboneNo);
           
           for(int i=0;i<faturalar.size();i++)
           {
               seri_1.getData().add(new XYChart.Data(faturalar.get(i).getAy(),
               faturalar.get(i).getFatura_Bedeli()));
           }
           barChart_1.getData().addAll(seri_1);
          
       
            break;
            }
            case "Isınma İçin Yapılan Harcama":
            {
                barChart_1.getData().clear();
                barChart_1.setTitle("Aylık Isınma İçin Yapılan Harcama Grafiğiniz");
                axisX_aylar.setLabel("Aylar");
                axisY_degerler.setLabel("TL");

               XYChart.Series seri_1 =new XYChart.Series<>();
               seri_1.setName("2017");

               faturaBilgileriDb fdb=new faturaBilgileriDb();
               ObservableList<fatura> faturalar=fdb.seciliAboneninTumFaturalari(aboneNo);

               for(int i=0;i<faturalar.size();i++)
               {
                   seri_1.getData().add(new XYChart.Data(faturalar.get(i).getAy(),
                   faturalar.get(i).getBitt()));
               }
               barChart_1.getData().addAll(seri_1);
               
               break;

            }
            case "Su Isıtma İçin Yapılan Harcama":
            {
                barChart_1.getData().clear();
                barChart_1.setTitle("Aylık Su Isıtma İçin Yapılan Harcama Grafiğiniz");
                axisX_aylar.setLabel("Aylar");
                axisY_degerler.setLabel("TL");

               XYChart.Series seri_1 =new XYChart.Series<>();
               seri_1.setName("2017");

               faturaBilgileriDb fdb=new faturaBilgileriDb();
               ObservableList<fatura> faturalar=fdb.seciliAboneninTumFaturalari(aboneNo);

               for(int i=0;i<faturalar.size();i++)
               {
                   seri_1.getData().add(new XYChart.Data(faturalar.get(i).getAy(),
                   faturalar.get(i).getSstft()));
               }
               barChart_1.getData().addAll(seri_1);
               
               break;
                
            }
            case "Isınma İçin Kullanılan kWh":
            {
                 barChart_1.getData().clear();
                barChart_1.setTitle("Aylık Isınma İçin Harcanan kWh Grafiğiniz");
                axisX_aylar.setLabel("Aylar");
                axisY_degerler.setLabel("kWh");

               XYChart.Series seri_1 =new XYChart.Series<>();
               seri_1.setName("2017");

               faturaBilgileriDb fdb=new faturaBilgileriDb();
               ObservableList<fatura> faturalar=fdb.seciliAboneninTumFaturalari(aboneNo);

               for(int i=0;i<faturalar.size();i++)
               {
                   seri_1.getData().add(new XYChart.Data(faturalar.get(i).getAy(),
                   faturalar.get(i).getBitm()));
               }
               barChart_1.getData().addAll(seri_1);
               
               break;
                
                
            }
            case "Harcanan Sıcak Su":
            {
                 barChart_1.getData().clear();
                barChart_1.setTitle("Aylık Harcanan Sıcak Su Grafiğiniz");
                axisX_aylar.setLabel("Aylar");
                axisY_degerler.setLabel("Litre");

               XYChart.Series seri_1 =new XYChart.Series<>();
               seri_1.setName("2017");

               faturaBilgileriDb fdb=new faturaBilgileriDb();
               ObservableList<fatura> faturalar=fdb.seciliAboneninTumFaturalari(aboneNo);

               for(int i=0;i<faturalar.size();i++)
               {
                   seri_1.getData().add(new XYChart.Data(faturalar.get(i).getAy(),
                   faturalar.get(i).getSsttt()));
               }
               barChart_1.getData().addAll(seri_1);
               
               break;
                
                
            }
        }
    }

    @FXML
    private void mesajlarima_gecisYapildi(Event event) throws ClassNotFoundException, SQLException {
        
        if(pane4.isSelected())
        {
            mesajIslemleriDb mid=new mesajIslemleriDb();
            login2Panel l2p=new login2Panel();
            ObservableList<mesaj> gelen=FXCollections.observableArrayList();
            gelen.add(mid.aliciNoyaGoreMesajVer(l2p.uyeNo_ver()));
            if(gelen != null)
            {
                tableColumn_gonderen.setCellValueFactory(new PropertyValueFactory<mesaj,String>("gondericiNo"));
                tableColumn_gonderimTar.setCellValueFactory(new PropertyValueFactory<mesaj,String>("gonderimTarihi"));
                tableColumn_icerik.setCellValueFactory(new PropertyValueFactory<mesaj,String>("icerik"));
                tableColumn_mesajNo.setCellValueFactory(new PropertyValueFactory<mesaj,String>("mesajNo"));
                tb_mesaj.setItems(gelen);
            
            }
            
            
           
            
           
            
            tb_mesaj.setRowFactory(new Callback<TableView<mesaj>, TableRow<mesaj>>() {
                @Override
                public TableRow<mesaj> call(TableView<mesaj> tv) {
                    TableRow<mesaj> row = new TableRow<>();
                    row.setOnMouseClicked(event -> {
                        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                            if(mesajDetayAcikMi)
                            {
                            try {
                 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mesajDetay/mesajDetayi.fxml"));
                     Parent root1 = (Parent) fxmlLoader.load();
                     Stage stage=new Stage();
                     MesajDetayiController controller=fxmlLoader.getController();
                     stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                     @Override
                     public void handle(WindowEvent event) {
                         mesajDetayAcikMi=true;
                     }
                 });
                     stage.setScene(new Scene(root1));  
                    
                    mesaj gelen=row.getItem();
                    controller.yazdir(gelen.getGondericiNo(),gelen.getIcerik());
                  
                    mesajDetayAcikMi=false;
                     
                     stage.show();
                     
                     //mesaj okundu kontrol kısmı
                     if(!mid.mesajNosuVerilenMesajOkunmusMu(gelen.getMesajNo()))
                         mid.okunduEvetYap(gelen.getMesajNo());
                         
                         
             } catch(Exception e) {
                e.printStackTrace();
               }
                            }
                        }
                    });
                    return row ;}
            });
            
            
        }
    }

    @FXML
    private void paraMatike_gecisYapildi(Event event) throws ClassNotFoundException, SQLException {
        if(pane5.isSelected())
        {
            if(pass_ParaMatik)
            {
                slider_1.valueProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        slider_1.setValue(Math.round(newValue.doubleValue()));
                        lbl_slider.setText(String.valueOf(slider_1.getValue()+" TL"));
                        txt_sliderDeger.setText(String.valueOf(slider_1.getValue()));
                    }
                });
                
                txt_sliderDeger.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        
                        lbl_slider.setTextFill(Color.WHITE);
                        txt_sliderDeger.setStyle("-fx-background-color: white;");
                        try{
                        slider_1.setValue(Double.parseDouble(txt_sliderDeger.getText()));
                    }
                        
                    catch(NumberFormatException ne)
                    {
                        lbl_slider.setText("Hatalı formatta veya boş bir değer girdiniz.");
                        slider_1.setValue(0);
                                
                   }
                    }
                });
                
                txt_krediKartNo.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                       txt_krediKartNo.setStyle("-fx-background-color: white;");
                       if(newValue.length() > 19)
                       {
                           txt_krediKartNo.setText(oldValue);
                       }
                       else
                       {
                           if(txt_krediKartNo.getText().isEmpty())
                           {
                               img_sirket.setImage(null);
                           }
                            if(newValue.length() > oldValue.length())
                       {
                           char karakter=newValue.charAt(newValue.length()-1);
                       int ascii=(int)karakter;
                       if(newValue != oldValue && !txt_krediKartNo.getText().isEmpty())
                       {
                       if(ascii >= 48 && ascii <=57)
                       {
                           if(newValue.length() == 4 || newValue.length() == 9 || newValue.length()==14)
                           {
                               txt_krediKartNo.setText(newValue+"-");
                           }
                           if(newValue.length() >= 1)
                           {
                               if(newValue.charAt(0) =='4')
                               {
                                   Image img1=new Image("/resimler/visa.png");
                                   img_sirket.setImage(img1);
                               }
                               else if(newValue.charAt(0) == '5')
                               {
                                   Image img2=new Image("/resimler/mastercard.png");
                                   img_sirket.setImage(img2);
                               }
                               else if(newValue.charAt(0)=='3')
                               {
                                   Image img3=new Image("/resimler/amex.png");
                                   img_sirket.setImage(img3);
                               }
                               else
                               {
                                   img_sirket.setImage(null);
                               }
                           }
                       }
                       else
                       {
                           if(karakter=='-' && newValue.length()==5)
                           {
                               
                           }
                           else if(karakter=='-' && newValue.length()==10)
                           {
                               
                           }
                           else if(karakter=='-' && newValue.length()==15)
                           {
                               
                           }
                           else
                           {
                               txt_krediKartNo.setText(oldValue);
                           }
                           
                       }
                              
                       }
                       }
                       }
                      
                      }
                    
                });
                
                txt_guvenlikKodu.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        
                       txt_guvenlikKodu.setStyle("-fx-background-color: white;");
                       if(newValue.length() > oldValue.length())
                       {
                            char karakter=newValue.charAt(newValue.length()-1);
                            int ascii=(int)karakter;
                            if(ascii >=48 && ascii<=57)
                            {
                                if(newValue.length()>3)
                                {
                                    txt_guvenlikKodu.setText(oldValue);
                                }
                            }
                            else
                            {
                                txt_guvenlikKodu.setText(oldValue);
                            }
                       }
                      
                    }
                });
                
                txt_sonKullanmaTarihi.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                     txt_sonKullanmaTarihi.setStyle("-fx-background-color: white;");
                     if(newValue.length() > 5)
                       {
                           txt_sonKullanmaTarihi.setText(oldValue);
                       }
                       else
                       {
                            if(newValue.length() > oldValue.length())
                       {
                           char karakter=newValue.charAt(newValue.length()-1);
                       int ascii=(int)karakter;
                       if(newValue != oldValue && !txt_sonKullanmaTarihi.getText().isEmpty())
                       {
                            if(ascii >= 48 && ascii <=57)
                       {
                           if(newValue.length() == 2 )
                           {
                               txt_sonKullanmaTarihi.setText(newValue+'/');
                           }
                       }
                       else
                       {
                           if(karakter=='/' && newValue.length()==3)
                           {
                               
                           }
                           else
                           {
                               txt_sonKullanmaTarihi.setText(oldValue);
                           }
                           
                    }
                       }
                       }
                       }
                    }
                });
                
                
                  islemOzetiniDoldur();
                   
                    
                }
            }
        }

    @FXML
    private void yukleBasildi(ActionEvent event) throws ClassNotFoundException, SQLException, UnsupportedEncodingException, MessagingException, IOException {
        
        if(txt_krediKartNo.getText().length() == 19 && txt_guvenlikKodu.getText().length()==3 &&
                txt_sonKullanmaTarihi.getText().length() == 5 && slider_1.getValue() > 0)
        {
            krediKartiAlgoritmalari kka=new krediKartiAlgoritmalari();
           
           
        
         
          
            if(kka.krediKartiGecerliMi(txt_krediKartNo.getText()) )
            {
                //burada email işlemi olacak
                String kod=kodVer();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/yuklemeOnayPenceresi/yuklemeOnayPenceresi.fxml"));
                     Parent root1 = (Parent) fxmlLoader.load();
                     Stage stage=new Stage();
                     controller=fxmlLoader.getController();
                kodEmailGonder(kod);
                
                if(yukleOnay && emailHataKontrol)
                            {
                            try {
                               
                  
                 
                     
                     stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                     @Override
                     public void handle(WindowEvent event) {
                         yukleOnay=true;
                     }
                 });
                     stage.setScene(new Scene(root1));  
                    
                
                    controller.setKod(kod);
                    controller.setAbonePaneliController(this);
                    controller.setStage((Stage)((Node)(event.getSource())).getScene().getWindow());
                  
                    yukleOnay=false;
                     
                     stage.show();
                     emailHataKontrol=false;
                
               
                
               

     
            
                    
                  
                    
                }
                 catch(Exception e)
                 {
                     
                 }
          
                        
               
                
            }
        
        }
            else
            {
                JOptionPane.showMessageDialog(null, "Hatalı Bir Kredi Kartı Numarası Girdiniz!","Hata"
                ,JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            String metin="";
            if(txt_krediKartNo.getText().length() != 19 )
            {
                txt_krediKartNo.setStyle("-fx-background-color: red;");
                metin+="# Kredi Kart Numarası 19 Haneli Olmalıdır.\n";
            }
            if(txt_guvenlikKodu.getText().length()!=3)
            {
                txt_guvenlikKodu.setStyle("-fx-background-color: red;");
                metin+="# Güvenlik Kodu 3 Haneli Olmalıdır.\n";
            }
            if(txt_sonKullanmaTarihi.getText().length() != 5)
            {
                txt_sonKullanmaTarihi.setStyle("-fx-background-color: red;");
                metin+="# Son Kullanma Tarihi 5 Haneli Olmalıdır.\n";
            }
            if(slider_1.getValue() == 0)
            {
                lbl_slider.setTextFill(Color.RED);
                txt_sliderDeger.setStyle("-fx-background-color: red;");
                metin+="# Yüklemek İstediğiniz Tutar Sıfırdan Farklı Olmalıdır.\n";
            }
            
            JOptionPane.showMessageDialog(null,"Kırmızı ile belirtilecek olan alanları düzeltiniz.\n"
            +metin,"Hata",JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void islemEmailBasildi(ActionEvent event) throws ClassNotFoundException, SQLException {
        
        if(sonIslem != null)
        {
            String email=JOptionPane.showInputDialog("Lütfen geçerli bir email adresi giriniz:");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String tarih= formatter.format(sonIslem.getIslemTarihi());
            
            String Text=tarih+" tarihinde "+sonIslem.getKrediKartNo()+
                    " numarali kredi kartiniz ile hesabınıza "+sonIslem.getMiktar()+" TL yukleme yaptiniz.";
            
             SendEmail se=new SendEmail();
             try
             {
                  se.emailGonder(email,"Hesaba Para Yükleme İşlem Özeti | Doğalgaz Otomasyon",Text);
             }
             catch(Exception e)
             {
                 if(e.getMessage().equals("Invalid Addresses"))
                     JOptionPane.showMessageDialog(null, "Hatalı bir Email Adresi Girdiniz","Hata",
                             JOptionPane.ERROR_MESSAGE);
             }
            
            
            
        }
        
     
    }
    public String kodVer()
    {
        Random rnd=new Random();
        ArrayList<String> liste=new ArrayList<>();
        String ifade="";
        for(int i=0;i<8;i++)
        {
            if(i<2)
            {
                int sayi=rnd.nextInt(9)+48;
                liste.add(Character.toString((char)sayi));
                
            }
            else if(i>=2 && i<4)
            {
                int sayi=rnd.nextInt(12)+35;
                liste.add(Character.toString((char)sayi));
            }
            else if(i>=4 && i<6)
            {
                int sayi=rnd.nextInt(25)+60;
                liste.add(Character.toString((char)sayi));
            }
            else
            {
                int sayi=rnd.nextInt(25)+97;
                liste.add(Character.toString((char)sayi));
            }
        }
        while(liste.size() != 0)
        {
            int indis=rnd.nextInt(liste.size());
            ifade+=liste.get(indis);
            liste.remove(indis);
        }
        return ifade;
    }
    
    public void kodOnaylandi() throws ClassNotFoundException, SQLException
    {
        double sayi=Double.parseDouble(txt_sliderDeger.getText());
        int sayiConverted=(int)sayi;
        paraMatikIslemleri pi=new paraMatikIslemleri();
        bakiyeIslemleri bi=new bakiyeIslemleri();
        login2Panel l2p=new login2Panel();
        String id=bi.idVer(l2p.uyeNo_ver());
        pi.islemGir("yukleme", sayiConverted, id,txt_krediKartNo.getText());
        bi.bakiyeArtir(sayiConverted, l2p.uyeNo_ver());
        sonIslem=pi.sonIslemiVer(id);
        
       
       //para yüklenme animasyonunu çalıştır
       if(ana_pane.getScene().getWindow().isShowing() == true)
       {
             //bir süre beklemek
        Timeline tl = new Timeline();
        tl.setCycleCount(Animation.INDEFINITE);
        KeyFrame moveBall = new KeyFrame(Duration.seconds(1),
                new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent event) {
                        
                        sayac++;
                        if(sayac==12)
                            try {
                                bakiyeAnimasyon();
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(AbonePaneliController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(AbonePaneliController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });

        tl.getKeyFrames().add(moveBall);
        tl.play();
       
          
       }
        //işlem yapıldı bilgilendirme emailini aktif edebiliriz
       btn_emailYolla.setDisable(false);
       slider_1.setValue(0);
       txt_guvenlikKodu.setText("");
       txt_krediKartNo.setText("");
       txt_emailAdresi.setText("");
       txt_sonKullanmaTarihi.setText("");
       
       islemOzetiniDoldur();
       
   
       
                
    }
    
    public void kodEmailGonder(String kod) throws UnsupportedEncodingException
    {
                controller.setKod(kod);
                String baslik="Hesabınıza Para Yükleme İşlemi Onayı | Doğalgaz Otomasyon";
              
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate localDate = LocalDate.now();
                String tarih=dtf.format(localDate); 
                
                String icerik=tarih+" tarihinde "+txt_krediKartNo.getText()+" numarali, kredi kartiniza "+txt_sliderDeger.getText()+" "
                        + " TL yukleme islemine kodu girerek onay vermeniz gereklidir."
                        + "Kodunuz : "+kod;
                String yeniIcerik=new String(icerik.getBytes("iso-8859-9"),"iso-8859-9");
                SendEmail se=new SendEmail();
        try {
            
            se.emailGonder(txt_emailAdresi.getText(),baslik,icerik);
            emailHataKontrol=true;
        } catch (MessagingException ex) {
            if(ex.getMessage().equals("Invalid Addresses"))
                JOptionPane.showMessageDialog(null, "Hatalı Email Adresi Girdiniz.","Hata",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void bakiyeAnimasyon() throws ClassNotFoundException, SQLException
    {
            login2Panel l2p=new login2Panel();
            bakiyeIslemleri bi=new bakiyeIslemleri();
            String bakiye=bi.bakiyeVer(l2p.uyeNo_ver());
            lbl_bakiye.setText(bakiye);
            //para yüklenme animasyonu
            ScaleTransition animasyon=new ScaleTransition(Duration.seconds(1),lbl_bakiye);
            animasyon.setByX(1.5f);
            animasyon.setByY(1.5f);
            animasyon.setCycleCount(2);
            animasyon.setAutoReverse(true);
            
            animasyon.play();
    }
    public void islemOzetiniDoldur() throws ClassNotFoundException, SQLException
    {
         //işlem özetini doldur
                    paraMatikIslemleri pi=new paraMatikIslemleri();
                    login2Panel l2p=new login2Panel();
                    bakiyeIslemleri bi=new bakiyeIslemleri();
                    String id=bi.idVer(l2p.uyeNo_ver());
                    ObservableList<paraMatik> gelen=pi.idYeGoreFaturalariVer(id);
                    if(gelen != null)
                    {
                        column_islemId.setCellValueFactory(new PropertyValueFactory<paraMatik,String>("id"));
                        column_islemTarihi.setCellValueFactory(new PropertyValueFactory<paraMatik,String>("islemTarihi"));
                        column_islem.setCellValueFactory(new PropertyValueFactory<paraMatik,String>("islemTuru"));
                        column_miktar.setCellValueFactory(new PropertyValueFactory<paraMatik,Integer>("miktar"));
                        column_krediKartNo.setCellValueFactory(new PropertyValueFactory<paraMatik,String>("krediKartNo"));

                        tb_islemOzeti.setItems(gelen);
                    }
                    
    }
    
    

   ChangeListener<fatura> listener =new ChangeListener<fatura>() {
        @Override
        public void changed(ObservableValue<? extends fatura> observable, fatura oldValue, fatura newValue) {
            try
            {
               if(table_faturalar.getSelectionModel().getSelectedItem().getOdenmeDurumu().equals("hayir") )
                btn_odemeYap.setDisable(false);
              else
                 btn_odemeYap.setDisable(true); 
            }
            catch(Exception e)
            {
                
            }
             
         
        }
    };

   

   

 

  
}    
    
    
    
    
   
    

    

