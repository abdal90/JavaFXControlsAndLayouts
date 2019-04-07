package switchingscenes;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SceneSwitcher extends Application {

    public static final int WIN_WIDTH = 400;
    public static final int WIN_HEIGHT = 300;
    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {

        this.stage = stage;

        // set up our initial scene
        stage.setTitle("Scene Switching");
        stage.setScene(getLoading());
        stage.show();

        // wait three seconds and then load our next scene
        KeyFrame Frame = new KeyFrame(Duration.millis(3000), event -> {
            // this function will fire off after 3 seconds have elapsed
            stage.setScene(getBody());
        });

        Timeline animation = new Timeline(Frame);
        animation.play();
    }

    private Scene getLoading(){
        VBox panel = new VBox();

        // set style css
        panel.setStyle("-fx-spacing: 10px; -fx-alignment: center");

        ProgressIndicator progress = new ProgressIndicator();
        Text message = new Text("Please wait");

        panel.getChildren().addAll(progress, message);

        return new Scene(panel, WIN_WIDTH, WIN_HEIGHT);

    }

    private Scene getBody(){
        return new Scene(new VBox(), WIN_WIDTH, WIN_HEIGHT);
    }

    private Scene getEnding(){
        return null;
    }





}
