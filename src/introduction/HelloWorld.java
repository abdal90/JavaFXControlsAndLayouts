package introduction;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloWorld extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // set some basic settings
        stage.setTitle("Hello World Application");

        // set scene
        stage.setScene(generateScene());


        // show window
        stage.show();
    }

    private Scene generateScene() {
        // create a panel to hold widgets ...
        VBox panel = new VBox();

        // set common spacing settings
        panel.setAlignment(Pos.CENTER);
        panel.setSpacing(10);
        panel.setPadding(new Insets(10,10,10,10));

        // add a few widgets
        Text header = new Text("Hello World");
        Text body = new Text("My first application is awesome!");


        // Node = widgets and panels
        panel.getChildren().addAll(header, body);

        return new Scene(panel);
    }
}
