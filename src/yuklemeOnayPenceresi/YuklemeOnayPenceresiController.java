/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yuklemeOnayPenceresi;

import abonePaneliIslemleri.AbonePaneliController;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.MessagingException;
import javax.naming.TimeLimitExceededException;

/**
 * FXML Controller class
 *
 * @author fince
 */
public class YuklemeOnayPenceresiController implements Initializable {

    @FXML
    private Label lbl_sure;
    @FXML
    private TextField txt_kod;
    @FXML
    private Button btn_onayla;
    @FXML
    private Button btn_tekrarGonder;
    private int kodSayi=100;

    private boolean onaylandi=false;
    private String kod;
    private AbonePaneliController apc;
    public Timeline tl;
    @FXML
    private ImageView img_kod;
    Stage aboneStage;
    private int sayi=0;
    @FXML
    private Label llb_gecisBilgi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     animasYon();
        
       
                
                    
    } 
    public void setKod(String kod)
    {
        this.kod=kod;
    }
    
    public void setAbonePaneliController(AbonePaneliController apc)
    {
        this.apc=apc;
    }

    @FXML
    private void onaylaBasildi(ActionEvent event) throws ClassNotFoundException, SQLException {
        if(kodSayi >0)
        {
            if(txt_kod.getText().equals(kod))
        {
            tl.stop();
            img_kod.setImage(new Image("/resimler/yes.png"));
            lbl_sure.setVisible(false);
            txt_kod.setDisable(false);
            apc.kodOnaylandi();
            
         //bir süre beklemek
            tl = new Timeline();
        tl.setCycleCount(Animation.INDEFINITE);
        KeyFrame moveBall = new KeyFrame(Duration.seconds(1),
                new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent event) {

                        sayi++;
                        int sayi2=10-sayi;
                        llb_gecisBilgi.setText("Otomatik olarak geçiş yapılıyor. ->"+sayi2);
                        if(sayi ==10)
                        {
                            tl.stop();
                            kapat();
                            
                          
                        }
                 
                    }
                });

        tl.getKeyFrames().add(moveBall);
        tl.play();
       
            
           
            
        }
        else
        {
            tl.stop();
            img_kod.setImage(new Image("/resimler/no.png"));
            lbl_sure.setText("0");
            txt_kod.setText("");
            btn_tekrarGonder.setDisable(false);
        }
        }
        
    }

    @FXML
    private void tekrarGonderBasildi(ActionEvent event) throws UnsupportedEncodingException, UnsupportedEncodingException, UnsupportedEncodingException, UnsupportedEncodingException, MessagingException, UnsupportedEncodingException, MessagingException, UnsupportedEncodingException, UnsupportedEncodingException {
        String kod=apc.kodVer();
        try {
            apc.kodEmailGonder(kod);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(YuklemeOnayPenceresiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        animasYon();
        btn_tekrarGonder.setDisable(true);
    }
    
    public void animasYon()
    {
        kodSayi=100;
        img_kod.setImage(null);
        
        tl = new Timeline();
        tl.setCycleCount(Animation.INDEFINITE);
        KeyFrame moveBall = new KeyFrame(Duration.seconds(1),
                new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent event) {

                        kodSayi--;
                        if(kodSayi ==10)
                            lbl_sure.setTextFill(Color.RED);
                        if(kodSayi ==0)
                        {
                              tl.stop();
                              btn_tekrarGonder.setDisable(false);
                              img_kod.setImage(new Image("/resimler/no.png"));
                              lbl_sure.setText("0");
                              txt_kod.setText("");
        
                        }
                          
                        lbl_sure.setText(String.valueOf(kodSayi));
                    }
                });

        tl.getKeyFrames().add(moveBall);
        tl.play();
    }

  
    
    public void setStage(Stage aboneStage)
    {
        this.aboneStage=aboneStage;
    }
    
    public void kapat()
    {
        ((Stage)(txt_kod.getScene().getWindow())).close();
        aboneStage.show();
        aboneStage.toFront();
       
    }
    
}
