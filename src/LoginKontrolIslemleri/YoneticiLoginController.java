/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginKontrolIslemleri;

import VeritabaniIslemleri.aboneLoginDb;
import VeritabaniIslemleri.yoneticiLoginDb;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author fince
 */
public class YoneticiLoginController implements Initializable {

    @FXML
    private TextField txt_aboneNo;
    @FXML
    private PasswordField txt_sifre;
    @FXML
    private Button btn_grsYap;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        yoneticiLoginDb yld=new yoneticiLoginDb();
        txt_aboneNo.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    if(yld.adminNoMevcutMu(txt_aboneNo.getText()))
                    {
                        txt_aboneNo.setStyle("-fx-text-fill: green;");
                    }
                    else
                         txt_aboneNo.setStyle("-fx-text-fill: red;");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AboneLoginController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AboneLoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
    }    

    @FXML
    private void girisYap_basildi(ActionEvent event) throws ClassNotFoundException, NoSuchAlgorithmException, SQLException {
        
        yoneticiLoginDb yld=new yoneticiLoginDb();
        if(yld.sifreKontrol(txt_sifre.getText(), txt_aboneNo.getText()))
            JOptionPane.showMessageDialog(null, "Giriş Başarılı");
        else
             JOptionPane.showMessageDialog(null, "Giriş Hatalı");
    }
    
}
