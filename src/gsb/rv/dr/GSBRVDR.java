/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsb.rv.dr;

import static java.sql.DriverManager.println;
import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import fr.gsb.rv.dr.entites.Visiteur;
import fr.gsb.rv.dr.technique.Session;
import fr.gsb.rv.dr.entites.Visiteur;
import com.mysql.jdbc.Driver;
import fr.gsb.rv.dr.modeles.ModeleGsbRv;
import static fr.gsb.rv.dr.modeles.ModeleGsbRv.seConnecter;
import fr.gsb.rv.dr.technique.ConnexionBD;
import fr.gsb.rv.dr.technique.ConnexionException;
import static java.awt.SystemColor.window;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Pair;



/**
 *
 * @author etudiant
 */
public class GSBRVDR extends Application {
    
    @Override
    public void start(Stage primaryStage) throws ConnexionException {
        
        //Visiteur visiteur=new Visiteur("OB001","BOUAICHI","Oumayma");
        
        
        
        
        BorderPane root=new BorderPane();
        
        Scene scene=new Scene(root,300,250);
        
        primaryStage.setScene(scene);
        
        MenuBar barreMenus=new MenuBar();
        
        Menu menuFichier=new Menu("Fichier");
        
        
        MenuItem itemSeConnecter=new MenuItem("Se connecter");
        
        MenuItem itemSeDéconnecter=new MenuItem("Se déconnecter");
        
        MenuItem itemQuitter=new MenuItem("Quitter");
        
        menuFichier.getItems().add(itemSeConnecter);
        
        menuFichier.getItems().add(itemSeDéconnecter);
        
        menuFichier.getItems().add(itemQuitter);
        
        Menu menuRapports=new Menu("Rapports");
        
        MenuItem itemConsulter=new Menu("Consulter");
        
        menuRapports.getItems().add(itemConsulter);
        
        Menu menuPracticiens=new Menu("Practiciens");
        
        MenuItem itemHésitants=new Menu("Hésitans");
        
        menuPracticiens.getItems().add(itemHésitants);
        
        barreMenus.getMenus().add(menuFichier);
        
        barreMenus.getMenus().add(menuRapports);
        
        barreMenus.getMenus().add(menuPracticiens);
        
        root.setTop(barreMenus);
        
        
       
        
        itemQuitter.setOnAction(
                new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Alert alertQuitter=new Alert(Alert.AlertType.CONFIRMATION);
                alertQuitter.setTitle("Quitter");
                alertQuitter.setHeaderText("Demande de confirmation");
                alertQuitter.setContentText("Voulez-vous quitter l'application");
                ButtonType btnOui=new ButtonType("Oui");
                ButtonType btnNon=new ButtonType("Non");
                alertQuitter.getButtonTypes().setAll(btnOui,btnNon);
                Optional<ButtonType> reponse=alertQuitter.showAndWait();
                reponse.get();
                if(reponse.get()==btnOui){
                    Platform.exit();
                }
                
                    
            }
                
                }
        );
        
        
        itemSeConnecter.setOnAction(actionEvent ->{
            //Session.ouvrir(visiteur);
            
            VueConnexion v1=new VueConnexion();
            Optional<Pair<String,String>> reponse=v1.showAndWait();
            if (reponse.isPresent()){
                try {
                    
                    Visiteur visiteur=seConnecter(reponse.get().getKey(),reponse.get().getValue());
                    Session.ouvrir(visiteur);
                    itemSeConnecter.setDisable(true);
                    menuRapports.setDisable(false);
                    menuPracticiens.setDisable(false);
                    itemSeDéconnecter.setDisable(false);
                    primaryStage.setTitle(visiteur.getNom()+" "+visiteur.getPrenom());
                            } catch (ConnexionException ex) {
                    Logger.getLogger(GSBRVDR.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("C'est faux");
            }
            //itemSeConnecter.setDisable(true);
            //menuRapports.setDisable(false);
            //menuPracticiens.setDisable(false);
            //itemSeDéconnecter.setDisable(false);
            //primaryStage.setTitle(visiteur.getNom()+" "+visiteur.getPrenom());
            
            
            
        }
                
        );
        
        itemSeDéconnecter.setOnAction(actionEvent ->{
            itemSeDéconnecter.setDisable(true);
            menuRapports.setDisable(true);
            menuPracticiens.setDisable(true);
            itemSeConnecter.setDisable(false);
            primaryStage.setTitle("GSB");
            //Session.fermer();
        }
        
                
                
        );
        
        
        
        itemConsulter.setOnAction(actionEvent ->{
            //System.out.println("[Rapports]"+" "+visiteur.getNom()+" "+visiteur.getPrenom());
            
            
            
            
            
            Label label1 = new Label("Bienvenue dans la vue des rapports");
            Button button1 = new Button("Retour");
            button1.setOnAction(e -> primaryStage.setScene(scene));
            
            VBox layout1=new VBox(20);
            layout1.getChildren().addAll(label1,button1);
            Scene scene1 = new Scene(layout1,500,500);
            
            primaryStage.setScene(scene1);
            primaryStage.show();
        }
        );
        
        itemHésitants.setOnAction(actionEvent ->{
            //System.out.println("[Praticiens]"+" "+visiteur.getNom()+" "+visiteur.getPrenom());
            Label label1 = new Label("Bienvenue dans la vue des practiciens");
            Button button1 = new Button("Retour");
            button1.setOnAction(e -> primaryStage.setScene(scene));
            
            VBox layout1=new VBox(20);
            layout1.getChildren().addAll(label1,button1);
            Scene scene1 = new Scene(layout1,500,500);
            
            primaryStage.setScene(scene1);
            primaryStage.show();
            
        }
        );
        
                             
            
            
        //Connection connexion=ConnexionBD.getConnexion();
        
        //System.out.println(seConnecter("a131","azerty"));
        
        
        
        
        
        primaryStage.setTitle("GSB");
        primaryStage.show();
        
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        

        


        
        launch(args);
        
        
    }
    
}
