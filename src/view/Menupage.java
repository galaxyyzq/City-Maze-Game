package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class Menupage extends StackPane {


    public Button cont = new Button("continue");
    //public Button reset = new Button("reset");
    public Button exit = new Button("exit");


    public void initial() {


        Text header = new Text("MENU");
        HBox textbox = new HBox();
        textbox.setPadding(new Insets(150, 12, 15, 12));
        textbox.getChildren().addAll(header);
        textbox.setAlignment(Pos.CENTER);

        VBox btnbox = new VBox(cont, exit);
        cont.setPrefSize(100,50);
        cont.setStyle("-fx-background-color:#FFA630");
        //reset.setPrefSize(100,50);
        //reset.setStyle("-fx-background-color:#FFA630");
        exit.setPrefSize(100,50);
        exit.setStyle("-fx-background-color:#FFA630");
        btnbox.setAlignment(Pos.CENTER);
        btnbox.setSpacing(30);
        btnbox.setPadding(new Insets(20, 0, 260, 0));
        btnbox.setAlignment(Pos.CENTER);

        BorderPane view = new BorderPane();
        view.setCenter(btnbox);
        view.setTop(textbox);

        this.getChildren().addAll(view);
        this.setStyle("-fx-background-color:#0FA3B1");

    }
}
