/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operationresearch.simplex.TheInput;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

/**
 *
 * @author Amr
 */


/**
 *
 * @author Amr
 */
public class Constrain extends VBox {

    private TextField xVal, yVal, rightVal;
    private String sign ;
    private ComboBox choice;


    public Constrain() {
        xVal = new TextField();
        xVal.setPrefWidth(70);
        xVal.setPrefHeight(30);

        Label plus = new Label("+");
        plus.setStyle("-fx-font-size: 14pt;");

        yVal = new TextField();
        yVal.setPrefWidth(70);
        yVal.setPrefHeight(30);
     
        choice = new ComboBox();
        choice.setPrefWidth(80);
        choice.setPrefHeight(30);
        choice.getItems().addAll("<=", ">=");   

        rightVal = new TextField();
        rightVal.setPrefWidth(70);
        rightVal.setPrefHeight(30);  

        this.setSpacing(5);
        getChildren().addAll(xVal, plus, yVal, choice, rightVal);

    }

    public TextField getxVal() {
        return xVal;
    }

    public void setxVal(TextField xVal) {
        this.xVal = xVal;
    }

    public TextField getyVal() {
        return yVal;
    }

    public void setyVal(TextField yVal) {
        this.yVal = yVal;
    }

    public TextField getRightVal() {
        return rightVal;
    }

    public void setRightVal(TextField rightVal) {
        this.rightVal = rightVal;
    }

    public ComboBox getChoice() {
        return choice;
    }

    public void setChoice(ComboBox choice) {
        this.choice = choice;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    
    

}

