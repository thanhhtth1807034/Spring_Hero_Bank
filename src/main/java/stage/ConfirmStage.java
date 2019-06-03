package stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmStage {
    static boolean answer;

    public static boolean display(String title, String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMaxWidth(300);
        Label label = new Label();
        label.setText(message);

        Button btnYes = new Button("Yes");
        Button btnNo = new Button("Nope");

        btnYes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                answer = true;
                window.close();
            }
        });
        btnNo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                answer = false;
                window.close();
            }
        });
        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(label, btnYes, btnNo);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox,400,200);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}
