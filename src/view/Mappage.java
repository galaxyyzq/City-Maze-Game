package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class Mappage extends GridPane {

    public Button start = new Button("start");

    public void initial() {

        //title of the page
        Text choose = new Text("Choose your destination by drag and drop");
        choose.setStyle("-fx-font: normal bold 26 Langdon; "
                + "-fx-base: #AE3522; "
                + "-fx-text-fill: orange;");
        this.add(choose, 1,0);

        this.add(start,2,2);

        VBox map = new VBox();
        Image world =  new Image("/sample/worldmap.jpg");
        ImageView imgView = new ImageView(world);
        map.getChildren().addAll(imgView);
        this.add(map,1,1);

        Image userimage =  new Image("/sample/boy.png");
        ImageView imageView = new ImageView(userimage);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        this.add(imageView, 0,1);


    }
}