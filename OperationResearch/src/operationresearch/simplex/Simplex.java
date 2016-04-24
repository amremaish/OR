/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operationresearch.simplex;

import insidefx.undecorator.UndecoratorScene;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import operationresearch.MainStage;
import operationresearch.simplex.TheInput.QInput;

/**
 *
 * @author Amr
 */
public class Simplex {

    QInput input;

    public UndecoratorScene DrawSimplex(Stage stage) {

        BorderPane root = new BorderPane();
           root.setPadding(new Insets(90, 0, 50, 10));
        input = new QInput();
        input.QInput(stage);
        root.setTop(input);
          
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
