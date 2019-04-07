package controls;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Random;

import static javafx.scene.text.FontWeight.BOLD;

public class PracticeWithControls extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        stage.setScene(createDialogs());
        stage.setTitle("Practicing with controls ");
        stage.show();
    }

    // buttons
    public Scene createButtons(){

        // creating a new buttons
        Button button = new Button("Click Me!");
        button.setPrefHeight(30);
        button.setPrefWidth(300);
        button.setAlignment(Pos.BOTTOM_RIGHT);

        // this our layout for controls
        VBox box = new VBox();
        box.getChildren().add(button);

        // set the spacing with my layout
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(20));

        // assign an event handler
        Random random = new Random();
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                button.setText("You clicked, here is a random number #: " + random.nextInt(100));
            }
        });

        return new Scene(box, 500,500);
    }

    // text elements - text, label, TextField, TextArea
    public Scene createTextElements(){

        VBox verticalStack = new VBox();
        verticalStack.setAlignment(Pos.CENTER);
        verticalStack.setPadding(new Insets(10));
        verticalStack.setSpacing(10);

        // add a banner using the text class
        Text banner = new Text();
        banner.setText("Enter information");
        banner.setFont(Font.font("Vani", FontWeight.BOLD, 30));
        banner.setUnderline(true);

        verticalStack.getChildren().add(banner);

        // add a few label fields
        Label nameLabel = new Label("Name: ");
        nameLabel.setAlignment(Pos.CENTER_LEFT);
        nameLabel.setPrefWidth(50);

        TextField nameEntry = new TextField();
        nameEntry.setPrefWidth(200);

        // group oogether my controls and add them to a parent layout
        HBox horizontalStack = new HBox();
        horizontalStack.setAlignment(Pos.CENTER);
        horizontalStack.getChildren().addAll(nameLabel, nameEntry);
        verticalStack.getChildren().add(horizontalStack);


        // add a few label fields
        Label bioLabel = new Label("Bio: ");
        bioLabel.setAlignment(Pos.CENTER_LEFT);
        bioLabel.setPrefWidth(50);

        TextArea bioEntry = new TextArea();
        bioEntry.setPrefWidth(200);
        bioEntry.setWrapText(true);

        // group oogether my controls and add them to a parent layout
        horizontalStack = new HBox();
        horizontalStack.setAlignment(Pos.CENTER);
        horizontalStack.getChildren().addAll(bioLabel, bioEntry);
        verticalStack.getChildren().add(horizontalStack);
        return new Scene(verticalStack, 500, 500);
    }

    // checkboxes, radio buttons
    public Scene createOptionalElements(){

        Text header = new Text("Favorite Color: ");
        header.setUnderline(true);

        // primariy layout
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(10));
        box.setSpacing(10);

        box.getChildren().add(header);

        // create several choices
        String[] choices = {"Blue", "Purple", "Pink", "Orange", "White"};
        CheckBox[] checkBoxes = new CheckBox[choices.length];
        for (int i = 0; i < choices.length; i++) {
            CheckBox chkBox = new CheckBox(choices[i]);
            box.setPrefWidth(100);
            box.setAlignment(Pos.CENTER_LEFT);

            checkBoxes[i] = chkBox;
            box.getChildren().add(chkBox);

        }

        // asign event handler to each checkbox
        for (int i = 0; i < checkBoxes.length; i++) {
            CheckBox chkBox = checkBoxes[i];

            chkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable,
                                    Boolean oldValue, Boolean newValue) {

                    chkBox.setText(chkBox.getText() + "(" + newValue + ")");
                }
            });
        }

        // preselect a textbox
        checkBoxes[0].setSelected(true);

        // radio buttons are ver similar
        RadioButton firstButton = new RadioButton();
        RadioButton secondButton = new RadioButton();

        // group together
        ToggleGroup groupedRadioButtons = new ToggleGroup();
        firstButton.setToggleGroup(groupedRadioButtons);
        secondButton.setToggleGroup(groupedRadioButtons);

        return new Scene(box, 200, 200);
    }

    // display images
    public Scene createOrShowImages() throws MalformedURLException {

        // load image into control
        Image image = new Image(new File("images/ubuntu.PNG")
                                .toURI().toURL().toString());

        ImageView imageControl = new ImageView(image);

        // resize the view Control

        imageControl.setFitWidth(400);
        imageControl.setFitHeight(400);

        VBox layout = new VBox();
        layout.getChildren().add(imageControl);

        return new Scene(layout, 400,400);
    }

    // lists - dropdown list(combo Box), List view
    public Scene createLists(){

        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.setSpacing(10);
        box.setPadding(new Insets(10));

        // display a drop down list

        //create a list
        ObservableList<String> items = FXCollections.
                observableArrayList("News paper","Friend","Local Ad", "Flyer", "Internet");
        // create a combo box
        ComboBox combo = new ComboBox();
        combo.getItems().addAll(items);

        // display a list
        items = FXCollections.
                observableArrayList("swimming","reading","tv", "movies", "music");

        ListView list = new ListView(items);

        //list can support multiple selections
        //list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable,
                                Object oldValue, Object newValue) {
                System.out.println("Selected: " + newValue);
            }
        });

        box.getChildren().addAll(combo, list);

        return new Scene(box, 300, 300);
    }

    // dialog boxes - color picker, Date picker
    public Scene createDialogs(){


        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.setSpacing(10);
        box.setPadding(new Insets(10));

        ColorPicker colors = new ColorPicker();
        box.getChildren().add(colors);

        //respond
        colors.valueProperty().addListener(new ChangeListener<Color>() {
            @Override
            public void changed(ObservableValue<? extends Color> observable,
                                Color oldValue, Color newValue) {
                System.out.println("Color Chosen: r=" + newValue.getRed() +
                        ", g= " + newValue.getGreen() + ", b= " + newValue.getBlue());

            }
        });

        // dates
        DatePicker dates = new DatePicker();
        box.getChildren().add(dates);

        return new Scene(box, 300, 300);
    }
}
