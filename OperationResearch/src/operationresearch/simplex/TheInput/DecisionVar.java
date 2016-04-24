/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operationresearch.simplex.TheInput;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class DecisionVar extends HBox {

  private  TextField var;

    public DecisionVar() {

        var = new TextField();
        Label plus = new Label("+");
        plus.setStyle("-fx-font-size: 16pt;");
        this.setSpacing(5);
        this.getChildren().addAll(var, plus);
    }

    public TextField getVar() {
        return var;
    }

    public void setVar(TextField var) {
        this.var = var;
    }
    
    
}
