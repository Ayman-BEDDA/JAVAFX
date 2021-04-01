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
public class PanneauRapports extends Dialog {
    
    public PanneauRapports(){
        
        super();
        
        VBox root2=new VBox();
        root2.getChildren().addAll(new Text("Rapports"));
        
    }
}
