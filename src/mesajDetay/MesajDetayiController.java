/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mesajDetay;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author fince
 */
public class MesajDetayiController implements Initializable {

    @FXML
    private TextField txt_gonderen;
    @FXML
    private TextArea txt_icerik;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void yazdir(String gonderen,String icerik)
    {
        txt_gonderen.setText(gonderen);
        String[] bol=icerik.split(" ");
        String ifade="";
        for(int i=0;i<bol.length;i++)
        {
            
            if(i%8==0)
            {
                ifade+="\n";
            }
            else
            {
                ifade+=bol[i]+" ";
            }
        }
        txt_icerik.setText(ifade);
    }
    
}
