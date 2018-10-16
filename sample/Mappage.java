package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class Mappage extends GridPane {

    public Button start = new Button("start");

    public void initial() {

        this.add(start,2,2);

        VBox map = new VBox();
        Image world =  new Image("./sample/worldmap.jpg");
        ImageView imgView = new ImageView(world);
        map.getChildren().addAll(imgView);
        this.add(map,1,1);

        Image userimage =  new Image("./sample/boy.png");
        ImageView imageView = new ImageView(userimage);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        this.add(imageView, 0,1);


    }
}