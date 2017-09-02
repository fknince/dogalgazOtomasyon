
package kiyasPaneli;

import VeritabaniIslemleri.faturaBilgileriDb;
import abonePaneliIslemleri.AbonePaneliController;
import fatura.fatura;
import java.lang.reflect.Field;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author fince
 */
public class İkiFaturaKiyasController implements Initializable {

    @FXML
    private ImageView img_1;
    @FXML
    private ImageView img_2;
    @FXML
    private Label label_id1;
    @FXML
    private Label label_id2;
    @FXML
    private Label lbl_istyg1;
    @FXML
    private Label lbl_igtyt1;
    @FXML
    private Label lbl_igssib1;
    @FXML
    private Label lbl_igop1;
    @FXML
    private Label lbl_opmbm1;
    @FXML
    private Label lbl_bitt1;
    @FXML
    private Label lbl_bitm1;
    @FXML
    private Label lbl_sstft1;
    @FXML
    private Label lbl_ssttt1;
    @FXML
    private Label lbl_ssbm1;
    @FXML
    private Label lbl_sosstft1;
    @FXML
    private Label lbl_ssttm1;
    @FXML
    private Label lbl_sosbm1;
    @FXML
    private Label lbl_sosbm2;
    @FXML
    private Label lbl_ssttm2;
    @FXML
    private Label lbl_sosstft2;
    @FXML
    private Label lbl_ssbm2;
    @FXML
    private Label lbl_ssttt2;
    @FXML
    private Label lbl_sstft2;
    @FXML
    private Label lbl_bitm2;
    @FXML
    private Label lbl_bitt2;
    @FXML
    private Label lbl_opmbm2;
    @FXML
    private Label lbl_igop2;
    @FXML
    private Label lbl_igssib2;
    @FXML
    private Label lbl_igtyt2;
    @FXML
    private Label lbl_istyg2;
    @FXML
    private Label lbl_faturaBedel1;
    @FXML
    private Label lbl_faturaBedel2;
    
    private int id1,id2;

  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        TranslateTransition tt=new TranslateTransition(Duration.millis(3000),img_1);
        tt.setByY(-178);
        tt.setCycleCount(1);
        tt.setAutoReverse(false);
        
        TranslateTransition tt2=new TranslateTransition(Duration.millis(3000),img_2);
        tt2.setByY(180);
        tt2.setCycleCount(1);
        tt2.setAutoReverse(false);
        
        
        
                
        ParallelTransition pt=new ParallelTransition(tt,tt2);
        pt.play();
        
        
        
    
     
        
     
        
        
        
        }
    public void yazdir(int id1,int id2) throws ClassNotFoundException, SQLException, IllegalArgumentException, IllegalAccessException
    {
        AbonePaneliController apc=new AbonePaneliController();
        faturaBilgileriDb fdb=new faturaBilgileriDb();
        fatura f1=fdb.seciliFaturayaAitBilgiler(String.valueOf(id1));
        fatura f2=fdb.seciliFaturayaAitBilgiler(String.valueOf(id2));
        label_id1.setText(f1.getFaturaNo());
        label_id2.setText(f2.getFaturaNo());
        labelaYazdir(f1.getFatura_Bedeli(), f2.getFatura_Bedeli(), lbl_faturaBedel1, lbl_faturaBedel2);
        labelaYazdir(f1.getBitm(), f2.getBitm(), lbl_bitm1, lbl_bitm2);
        labelaYazdir(f1.getBitt(), f2.getBitt(), lbl_bitt1, lbl_bitt2);
        labelaYazdir(f1.getIgop(), f2.getIgop(), lbl_igop1, lbl_igop2);
        labelaYazdir(f1.getIgssib(), f2.getIgssib(), lbl_igssib1, lbl_igssib2);
        labelaYazdir(f1.getIgtyt(), f2.getIgtyt(), lbl_igtyt1, lbl_igtyt2);
        labelaYazdir(f1.getIstyg(), f2.getIstyg(), lbl_istyg1, lbl_istyg2);
        labelaYazdir(f1.getOpmbm(), f2.getOpmbm(), lbl_opmbm1, lbl_opmbm2);
        labelaYazdir(f1.getSosbm(), f2.getSosbm(), lbl_sosbm1, lbl_sosbm2);
        labelaYazdir(f1.getSosstft(), f2.getSosstft(), lbl_sosstft1, lbl_sosstft2);
        labelaYazdir(f1.getSsbm(), f2.getSsbm(), lbl_ssbm1, lbl_ssbm2);
        labelaYazdir(f1.getSstft(), f2.getSstft(), lbl_sstft1, lbl_sstft2);
        labelaYazdir(f1.getSsttm(), f2.getSsttm(), lbl_ssttm1, lbl_ssttm2);
        labelaYazdir(f1.getSsttt(), f2.getSsttt(), lbl_ssttt1, lbl_ssttt2);
        
      
    }
    
    public void labelaYazdir(Float gelen1,Float gelen2,Label l1,Label l2)
    {
        if(gelen1 > gelen2)
        {
            l1.setText(String.valueOf(gelen1));
            l1.setTextFill(Color.RED);
            
            l2.setText(String.valueOf(gelen2));
            l2.setTextFill(Color.GREEN);
        }
        else if(gelen1< gelen2)
        {
            l1.setText(String.valueOf(gelen1));
            l1.setTextFill(Color.GREEN);
            
            l2.setText(String.valueOf(gelen2));
            l2.setTextFill(Color.RED);
        }
        else
        {
            l1.setText(String.valueOf(gelen1));
            l1.setTextFill(Color.BLACK);
            
            l2.setText(String.valueOf(gelen2));
            l2.setTextFill(Color.BLACK);
        }
    }

   
        
        
        
        
    
}
