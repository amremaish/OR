/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operationresearch.simplex;

import insidefx.undecorator.UndecoratorScene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import operationresearch.MainStage;

/**
 *
 * @author Amr
 */
public class Simplex {

    public UndecoratorScene DrawSimplex(Stage stage) {

        BorderPane root = new BorderPane();
       
        // The Undecorator as a Scene
        UndecoratorScene undecoratorScene = new UndecoratorScene(stage, root, true);
        undecoratorScene.getStylesheets().add(MainStage.class.getResource("StyleSheet.css").toExternalForm());
        /*
         * Fade out transition on window closing request
         */
        stage.setOnCloseRequest((WindowEvent we) -> {
            we.consume();   // Do not hide yet
            undecoratorScene.setFadeOutTransition();
        });
        stage.toFront();
        stage.setTitle("Simplex ");
        return undecoratorScene;
    }

}
