/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginKontrolIslemleri;

import VeritabaniIslemleri.aboneLoginDb;
import VeritabaniIslemleri.login2Panel;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author fince
 */
public class AboneLoginController implements Initializable {

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
        aboneLoginDb ald=new aboneLoginDb();
        txt_aboneNo.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    if(ald.aboneNoMevcutMu(txt_aboneNo.getText()))
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
    private void girisYap_basildi(ActionEvent event) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        aboneLoginDb ald=new aboneLoginDb();
        if(ald.sifreKontrol(txt_sifre.getText(), txt_aboneNo.getText()))
        {
             login2Panel l2p=new login2Panel();
             l2p.gecisYapildi(ald.uyeNoVer(txt_aboneNo.getText()));
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/abonePaneliIslemleri/abonePaneli.fxml"));
                     Parent root1 = (Parent) fxmlLoader.load();
                     Stage stage=new Stage();
                     stage.setScene(new Scene(root1));
                     
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                try {
                    ald.sonGirisTarihiGuncelle(l2p.uyeNo_ver());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AboneLoginController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AboneLoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

                     stage.show();
             } catch(Exception e) {
                e.printStackTrace();
               }
         ((Stage)txt_aboneNo.getScene().getWindow()).close();
        }
        else
             JOptionPane.showMessageDialog(null, "Giriş Hatalı");
    }
    
}
