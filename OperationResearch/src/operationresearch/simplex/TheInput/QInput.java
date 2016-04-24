/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operationresearch.simplex.TheInput;

import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Amr
 */
public class QInput extends BorderPane {


    private Stack<DecisionVar> StackOfDecisionVar;
    HBox box;
    Stage stage;

    public void QInput(Stage stage) {
        StackOfDecisionVar = new Stack();
        this.stage = stage;
        box = new HBox();
        box.setPadding(new Insets(0, 10, 0, 0));
        
        box.setSpacing(20);
        
        this.setCenter(box);

       DecisionVar init = new DecisionVar();
        StackOfDecisionVar.push(init);

        box.getChildren().addAll(init);

        Separator separator = new Separator();
        separator.setOrientation(Orientation.HORIZONTAL);

        this.setRight(separator);

        ConstarinNumberControl();
        WidthConstrainControl();

    }

    private void ConstarinNumberControl() {

        Timer t2 = new Timer();
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
               DecisionVar last = StackOfDecisionVar.get(StackOfDecisionVar.size() - 1);
                last.getVar().setOnMouseClicked((MouseEvent e) -> {
                    if (last == StackOfDecisionVar.get(StackOfDecisionVar.size() - 1)) {
                        DecisionVar newConst = new DecisionVar();
                        StackOfDecisionVar.push(newConst);
                        box.getChildren().add(newConst);
                    }
                    for (int i = 0; i < StackOfDecisionVar.size(); i++) {
                        System.out.println(StackOfDecisionVar.size());
                        if (StackOfDecisionVar.get(i).getVar().getText().equals("") && i != StackOfDecisionVar.size() - 2 && i != StackOfDecisionVar.size() - 1) {
                            box.getChildren().remove(StackOfDecisionVar.get(i));
                            StackOfDecisionVar.remove(StackOfDecisionVar.get(i));
                        }
                    }
                });
            }
        };

        t2.scheduleAtFixedRate(task2, 100, 100);

    }

    private void WidthConstrainControl() {

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    box.setPrefWidth(stage.getWidth() / 4);
                });
            }

        }, 100, 100);
    }

}
