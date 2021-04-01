/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsb.rv.dr;

import fr.gsb.rv.dr.technique.ConnexionException;
import static javafx.application.Application.launch;
import javafx.scene.control.Button;
import static javafx.scene.control.ButtonBar.ButtonData.CANCEL_CLOSE;
import static javafx.scene.control.ButtonBar.ButtonData.OK_DONE;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Pair;
import static jdk.nashorn.internal.objects.NativeJava.type;


/**
 *
 * @author etudiant
 */
public class VueConnexion extends Dialog {
    
        
        
        
        public VueConnexion() {
            
            super();
            
            Label mat=new Label("Matricule:");
            Label mdp=new Label("Mot de passe:");
            TextField matri=new TextField();
            PasswordField mdpp=new PasswordField();
            VBox vb1=new VBox();
            
            
            
            
            vb1.getChildren().addAll(mat,mdp,matri,mdpp);
            this.getDialogPane().setContent(vb1);
            
            ButtonType button1=new ButtonType("Valider",OK_DONE);
            ButtonType button2=new ButtonType("ANNULER",CANCEL_CLOSE);
            
            
        
            this.getDialogPane().getButtonTypes().addAll(button1,button2);
        
            setTitle("Authentification");
        
            setHeaderText("Saisir vos données de connexion");
            
            
            
            
            setResultConverter(
                    new Callback<ButtonType,Pair<String,String>>(){
                        @Override
                        public Pair<String,String> call (ButtonType typeBouton){
                            if( typeBouton == button1 ){
                                return new Pair<String,String>(matri.getText(),mdpp.getText());
                            }
                            return null;
                        }
                    }
            );
        }
      
    
    
}
