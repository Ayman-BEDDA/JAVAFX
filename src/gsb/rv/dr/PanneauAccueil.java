/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsb.rv.dr;

import javafx.scene.control.Dialog;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author etudiant
 */
public class PanneauAccueil extends Dialog {
    
    public PanneauAccueil(){
        
        super();
        
        VBox root1=new VBox(20);
        root1.getChildren().addAll(new Text("Accueil"));
        
    }
}
