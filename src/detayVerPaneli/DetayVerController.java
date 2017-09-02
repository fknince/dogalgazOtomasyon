/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detayVerPaneli;

import VeritabaniIslemleri.faturaBilgileriDb;
import eMailGonderici.EmailAttachmentSender;
import fatura.fatura;
import java.awt.Desktop;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.jnlp.PrintService;
import javax.print.Doc;
import javax.print.DocPrintJob;
import javax.print.SimpleDoc;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.printing.PDFPageable;

/**
 * FXML Controller class
 *
 * @author fince
 */
public class DetayVerController implements Initializable {

    @FXML
    private Label lbl_faturaNo;
    @FXML
    private Label lbl_daireAlani;
    @FXML
    private Label lbl_faturaBedeli;
    @FXML
    private Label lbl_ayVeYil;
    @FXML
    private Label lbl_sonOdemeTar;
    @FXML
    private Label lbl_odenmeDurumu;
    @FXML
    private Label lbl_odenmeTarihi;
    @FXML
    private Label lbl_istyg;
    @FXML
    private Label lbl_igtyt;
    @FXML
    private Label lbl_igssib;
    @FXML
    private Label lbl_igop;
    @FXML
    private Label lbl_opmbm;
    @FXML
    private Label lbl_opt;
    @FXML
    private Label lbl_bitt;
    @FXML
    private Label lbl_bitm;
    @FXML
    private Label lbl_sstft;
    @FXML
    private Label lbl_ssttt;
    @FXML
    private Label lbl_ssbm;
    @FXML
    private Label lbl_sosstft;
    @FXML
    private Label lbl_ssttm;
    @FXML
    private Label lbl_sosbm;
    @FXML
    private Button btn_pdfVer;
    @FXML
    private Button btn_Yazdir;
    @FXML
    private Button btn_Email;
    
    private String faturaAy,faturaYil,yol;
    @FXML
    private AnchorPane ana_pane;
    
    private Stage stage;
    @FXML
    private Button btn_odemeYap;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    

    @FXML
    private void pdfVer_Basildi(ActionEvent event) throws IOException {
        WritableImage snapImage = btn_pdfVer.getScene().snapshot(null);
        PixelReader reader = snapImage.getPixelReader();
        WritableImage newImage = new WritableImage(reader,555,500);
        
        //dosyanın kaydedileceği yer
         DirectoryChooser directoryChooser = new DirectoryChooser();
                File selectedDirectory = 
                        directoryChooser.showDialog(lbl_ayVeYil.getScene().getWindow());
                 
                if(selectedDirectory == null){
                    JOptionPane.showMessageDialog(null, "Kaydedilecek klasörü seçmediniz.");
                }else{
                    yol=selectedDirectory.getAbsolutePath();
                    File f=new File(yol+"\\"+faturaYil+faturaAy+"FaturaDetayi.png");
        ImageIO.write(SwingFXUtils.fromFXImage(newImage, null), "png", f);
        
         
        String fileName = yol+"\\"+faturaYil+faturaAy+"FaturaDetayi.pdf";
        String imageName = yol+"\\"+faturaYil+faturaAy+"FaturaDetayi.png";

        try {

            PDDocument doc = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            
           
            doc.addPage(page);

            PDImageXObject image=PDImageXObject.createFromFile(imageName, doc);
          

            PDPageContentStream content = new PDPageContentStream(doc, page);
            

            content.drawImage(image,20,170);

            content.close();

            doc.save(fileName);

            doc.close();
            
          
          JOptionPane.showMessageDialog(null, "Belirlediğiniz klasöre fatura detayınızın pdf'i oluşturuldu.","Bilgi",
                  JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
                }
        

      
    }

    @FXML
    private void yazdirBasildi(ActionEvent event) throws IOException
    {
        File f;
        try
        {
            if(yol !=null)
            {
                f=new File(yol+"\\"+faturaYil+faturaAy+"FaturaDetayi.png");
                Desktop.getDesktop().print(f);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"İlk önce faturanızın PDF'ni kayıt ediniz.","Hata",JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception e)
        {
             
                     
                    
        }
        
    }

    @FXML
    private void eMailBasildi(ActionEvent event) {
       
        if(yol != null)
        {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("E-Mail olarak gönderilecek PDF dosyanızı seçiniz.");
            fileChooser.getExtensionFilters().addAll(
            new ExtensionFilter("PDF Files", "*.pdf"));
            fileChooser.setInitialDirectory(new File(yol));
            File selectedFile=fileChooser.showOpenDialog(stage);
            
            
            if(selectedFile != null)
            {
                //e mail gönderme işlemleri
                EmailAttachmentSender ems=new EmailAttachmentSender();
                String emailAdres=JOptionPane.showInputDialog(null, "E-Mail adresinizi giriniz.");
                String baslik=faturaYil+"/"+faturaAy+" Tarihli Fatura Detayı";
                String icerik="İlgili pdf ektedir.";
                String[] attachFiles = new String[1];
                attachFiles[0] = selectedFile.getAbsolutePath();
                try
                {
                    ems.sendEmailWithAttachments(emailAdres, baslik, icerik, attachFiles);
                    JOptionPane.showMessageDialog(null, "E-Mail gönderildi","Bilgi",JOptionPane.INFORMATION_MESSAGE);
                }
                catch(Exception e)
                {
                       if(e.getMessage().equals("Invalid Addresses"))
                       {
                           JOptionPane.showMessageDialog(null, "Hatalı E-mail Adresi Girdiniz");
                          
                       }
                }
            }
        }
        else
        {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("E-Mail olarak gönderilecek PDF dosyanızı seçiniz.");
            fileChooser.getExtensionFilters().addAll(
            new ExtensionFilter("PDF Files", "*.pdf"));
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            File selectedFile=fileChooser.showOpenDialog(stage);
         
            
            if(selectedFile != null)
            {
                //e mail gönderme işlemleri
                EmailAttachmentSender ems=new EmailAttachmentSender();
                String emailAdres=JOptionPane.showInputDialog(null, "E-Mail adresinizi giriniz.");
                String baslik=faturaYil+"/"+faturaAy+" Tarihli Fatura Detayı";
                String icerik="İlgili pdf ektedir.";
                String[] attachFiles = new String[1];
                attachFiles[0] = selectedFile.getAbsolutePath();
                try
                {
                    ems.sendEmailWithAttachments(emailAdres, baslik, icerik, attachFiles);
                    JOptionPane.showMessageDialog(null, "E-Mail gönderildi","Bilgi",JOptionPane.INFORMATION_MESSAGE);
                }
                catch(Exception e)
                {
                       if(e.getMessage().equals("Invalid Addresses"))
                       {
                           JOptionPane.showMessageDialog(null, "Hatalı E-mail Adresi Girdiniz");
                          
                       }
                }
            }
        }
        
        
        
    }
    
    public void yazdir(String faturaNo) throws ClassNotFoundException, SQLException
    {
        faturaBilgileriDb fdb=new faturaBilgileriDb();
        fatura f=fdb.seciliFaturayaAitBilgiler(faturaNo);
        
        if(f.getOdenmeDurumu().equals("hayir"))
            btn_odemeYap.setVisible(true);
        else
            btn_odemeYap.setVisible(false);
        
        faturaAy=f.getAy();
        faturaYil=f.getYil();
        
        lbl_faturaNo.setText(f.getFaturaNo());
        lbl_ayVeYil.setText(f.getYil()+"/"+f.getAy());
        lbl_bitm.setText(String.valueOf(f.getBitm()));
        lbl_bitt.setText(String.valueOf(f.getBitt()));
        lbl_daireAlani.setText(String.valueOf(f.getDaire_alani()));
        lbl_faturaBedeli.setText(String.valueOf(f.getFatura_Bedeli()));
        lbl_igop.setText(String.valueOf(f.getIgop()));
        lbl_igssib.setText(String.valueOf(f.getIgssib()));
        lbl_igtyt.setText(String.valueOf(f.getIgtyt()));
        lbl_istyg.setText(String.valueOf(f.getIstyg()));
        lbl_odenmeDurumu.setText(String.valueOf(f.getOdenmeDurumu()));
     
        lbl_opmbm.setText(String.valueOf(f.getOpmbm()));
        lbl_opt.setText(String.valueOf(f.getOpt()));
       
        lbl_sosbm.setText(String.valueOf(f.getSosbm()));
        lbl_sosstft.setText(String.valueOf(f.getSosstft()));
        lbl_ssbm.setText(String.valueOf(f.getSsbm()));
        lbl_sstft.setText(String.valueOf(f.getSstft()));
        lbl_ssttm.setText(String.valueOf(f.getSsttm()));
        lbl_ssttt.setText(String.valueOf(f.getSsttt()));
        
        
        Date gelen=f.getOdenmeTar();
        if(gelen != null)
        {
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
            String donecek=DATE_FORMAT.format(gelen);
            lbl_odenmeTarihi.setText(String.valueOf(donecek));
        }
        else
            lbl_odenmeTarihi.setText("");
        
        
        Date gelen2=f.getOdenmeTar();
        if(gelen2 != null)
        {
            SimpleDateFormat DATE_FORMAT2 = new SimpleDateFormat("dd-MM-yyyy");
            String donecek2=DATE_FORMAT2.format(gelen2);
            lbl_sonOdemeTar.setText(donecek2);
        }
        else
            lbl_sonOdemeTar.setText("");
       
        
    }
    
    
    
}
