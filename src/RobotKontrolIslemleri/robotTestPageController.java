/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RobotKontrolIslemleri;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 *
 * @author fince
 */
public class robotTestPageController implements Initializable {
    
  
    @FXML
    private AnchorPane main_pane;
    @FXML
    private ImageView img_bck;
    @FXML
    private GridPane grd_shapes;
    @FXML
    private Button btn_again;
    @FXML
    private Button btn_accept;
    
    private String[] secenek={"Dikdortgen","Yuvarlak"};
    private EventHandler<MouseEvent> tiklandi;
    private int dikdortgenSayisi,yuvarlakSayisi;
    private int kontrol_secenek;
    private boolean tiklanma=false;
    private boolean[][] tiklanma_durumlari={{false,false},{false,false},{false,false}};
    
    private String id;
    private boolean[] onay={false,false,false,false,false,false};
    @FXML
    private Label lbl_bilgi;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        

        
        img_bck.setImage(new Image("resimler/dogalgaz.jpg"));
        img_bck.setOpacity(0.25);
        Random rnd=new Random();
        
        
        
        tiklandi= new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int row=GridPane.getRowIndex(((ImageView)event.getSource()));
                int column=GridPane.getColumnIndex(((ImageView)event.getSource()));
                
              
              
                
                
                if(((ImageView)event.getSource()).getOpacity() == 1.0)
                {
                    ((ImageView)event.getSource()).setOpacity(0.5);
                    tiklanma_durumlari[row][column]=true;
                    
                        
                }
                else
                {
                    ((ImageView)event.getSource()).setOpacity(1);
                    tiklanma_durumlari[row][column]=false;
                }
                
                
       
                
                
            }
        };
    
        ArrayList<ImageView> gelen=shake_shapes();
        
        id=secenek[kontrol_secenek];
        lbl_bilgi.setText("Lütfen robot testi için aşağıdaki ["+id+"] şekilini/şekillerini seçip.Onayla butonuna basınız.");
        
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<3;j++)
            {
                int indis=rnd.nextInt(gelen.size());
                grd_shapes.add(gelen.get(indis), i, j);
                gelen.remove(indis);
            }
        }
        
  
        
    
       
        
    }
    

    public ArrayList<ImageView> shake_shapes()
    {
        ArrayList<ImageView> donecek=new ArrayList<>();
        Random rnd=new Random();
        kontrol_secenek=rnd.nextInt(2);
        dikdortgenSayisi=rnd.nextInt(5)+1;
        yuvarlakSayisi=6-dikdortgenSayisi;
        Image dikdortgen=new Image("resimler/rect.png");
        Image yuvarlak=new Image("resimler/circle.png");
        
        
        for(int i=0;i<dikdortgenSayisi;i++)
        {
            ImageView iv=new ImageView();
            iv.setImage(dikdortgen);
            iv.setOnMouseClicked(tiklandi);
            iv.setFitWidth(150);
            iv.setFitHeight(80);
            iv.setId("Dikdortgen");
            donecek.add(iv);
           
        }
        for(int i=0;i<yuvarlakSayisi;i++)
        {
            ImageView iv=new ImageView();
            iv.setImage(yuvarlak);
            iv.setOnMouseClicked(tiklandi);
            iv.setFitWidth(90);
            iv.setFitHeight(90);
            iv.setId("Yuvarlak");
            donecek.add(iv);
           
        }
        return donecek;
       
    }

    @FXML
    private void yenidenSekilVer_Basildi(ActionEvent event) {
        grd_shapes.getChildren().clear();
        Random rnd=new Random();
        ArrayList<ImageView> gelen=shake_shapes();
        
        
        id=secenek[kontrol_secenek];
        lbl_bilgi.setText("Lütfen robot testi için aşağıdaki ["+id+"] şekilini/şekillerini seçip.Onayla butonuna basınız.");
        
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<3;j++)
            {
                tiklanma_durumlari[j][i]=false;
                int indis=rnd.nextInt(gelen.size());
                grd_shapes.add(gelen.get(indis), i, j);
                gelen.remove(indis);
            }
        }
        
    }

    @FXML
    private void onayla_Basildi(ActionEvent event) {
        int sayac=0;
        for(Node node : grd_shapes.getChildren())
        {
            
            
            
            if(((ImageView)node).getId().equals(id))
            {
                int row=GridPane.getRowIndex(((ImageView)node));
                int column=GridPane.getColumnIndex(((ImageView)node));
                if(tiklanma_durumlari[row][column] == false)
                    onay[sayac]=false;
                else
                    onay[sayac]=true;
             
            }
            else
            {
                int row=GridPane.getRowIndex(((ImageView)node));
                int column=GridPane.getColumnIndex(((ImageView)node));
                if(tiklanma_durumlari[row][column])
                    onay[sayac]=false;
                else
                    onay[sayac]=true;   
            }
            sayac++;
     
           
        
        }
        
        if(onay[0] & onay[1] & onay[2] & onay[3] & onay[4]& onay[5] )
        {
            main_pane.getChildren().clear();
            ImageView img=new ImageView(new Image("resimler/dogalgaz.jpg"));
            img.setFitWidth(main_pane.getWidth());
            img.setFitHeight(main_pane.getHeight());
            main_pane.getChildren().add(img);
            FadeTransition ft=new FadeTransition(Duration.millis(3000),img);
            ft.setFromValue(0.25);
            ft.setToValue(1.0);
            ft.setCycleCount(0);
            ft.setAutoReverse(false);
            
            Button k_girisi=new Button("Kullanıcı Girişi");
            k_girisi.setPrefSize(200, 50);
            k_girisi.setLayoutX(200);
            k_girisi.setLayoutY(20);
            k_girisi.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/LoginKontrolIslemleri/aboneLogin.fxml"));
                     Parent root1 = (Parent) fxmlLoader.load();
                     Stage stage=new Stage();
                     stage.setScene(new Scene(root1));  
                     stage.show();
             } catch(Exception e) {
                e.printStackTrace();
               }
         ((Stage)k_girisi.getScene().getWindow()).close();
                }
            });
            main_pane.getChildren().add(k_girisi);
            
             Button y_girisi=new Button("Yönetici Girişi");
            y_girisi.setPrefSize(200, 50);
            y_girisi.setLayoutX(200);
            y_girisi.setLayoutY(90);
            y_girisi.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                      try {
                 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/LoginKontrolIslemleri/yoneticiLogin.fxml"));
                     Parent root1 = (Parent) fxmlLoader.load();
                     Stage stage=new Stage();
                     stage.setScene(new Scene(root1));  
                     stage.show();
             } catch(Exception e) {
                e.printStackTrace();
               }
         ((Stage)k_girisi.getScene().getWindow()).close();
                    
                }
            });
            main_pane.getChildren().add(y_girisi);
            
            ft.play();
            
        }
        else
             JOptionPane.showMessageDialog(null, "Giriş Hatalı");
   
    }
    
 
    
    
    
}
