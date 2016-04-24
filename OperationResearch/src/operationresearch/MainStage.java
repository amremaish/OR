package operationresearch;

import insidefx.undecorator.UndecoratorScene;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import operationresearch.Graphical.Graphical;
import operationresearch.simplex.Simplex;

public class MainStage {

    private final int STAGE_HEIGHT = 500;
    private final int STAGE_WIDTH = 800;

    public void showMainStage() throws IOException {
        BuildStage();
    }

    public void BuildStage() {
        Stage stage = new Stage();
        stage.setHeight(STAGE_HEIGHT);
        stage.setWidth(STAGE_WIDTH);

        GridPane child = new GridPane();
        BorderPane root = new BorderPane(child);       // Main Pane

        Menu file = new Menu("File ");
        Menu Edit = new Menu("Edit ");

        MenuBar bar = new MenuBar(file, Edit);

        //select Posision 
        root.setTop(bar);
        root.setCenter(child);

        child.setPadding(new Insets(25, 25, 25, 25));
        child.setPadding(new Insets(100));
        child.setHgap(10);
        child.setVgap(10);
        child.setPrefSize(300, 300);
        Button graphical = new Button("graphical");
        graphical.setOnAction(e -> stage.setScene(new Graphical().DrawGraphical(stage)));  // open Gpraphical scene
        graphical.setPrefSize(100, 100);

        Button Simplex = new Button("Simplex");
        Simplex.setOnAction(e -> stage.setScene(new Simplex().DrawSimplex(stage)));  // open Gpraphical scene
        Simplex.setPrefSize(100, 100);  // set Size 

        child.add(graphical, 0, 0);     // Add button to BorderPane (0,0)
        child.add(Simplex, 1, 0);

        BorderPane.setMargin(bar, new Insets(20, 0, 0, 30));  // move my bar to down and right

        // The Undecorator as a Scene
        UndecoratorScene undecoratorScene = new UndecoratorScene(stage, root, false);

        //  set Style 
        undecoratorScene.getStylesheets().add(MainStage.class.getResource("StyleSheet.css").toExternalForm());

        undecoratorScene.setFadeInTransition();
        /*
         * Fade out transition on window closing request
         */
        stage.setOnCloseRequest((WindowEvent we) -> {
            we.consume();   // Do not hide yet
            undecoratorScene.setFadeOutTransition();
        });

        stage.setScene(undecoratorScene);
        stage.toFront();
        stage.show();
        stage.setTitle("Main");
    }

}
