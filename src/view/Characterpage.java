package view;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import controller.charactercontroller;

public class Characterpage extends GridPane {




    public Characterpage(){

    }

    public Button ok = new Button("OK");
    public Button BackBtn = new Button("Back");
    public Button MaleBtn ;
    public Button FemaleBtn;// = new Button();
    public Button Color1 ;
    public Button Color2 ;
    public Button Color3 ;
    public Button Color4 ;
    public ImageView imgView;


    public void initial() {

        FemaleBtn = new Button();
        MaleBtn = new Button();
        Color1 = new Button();
        Color2 = new Button();
        Color3 = new Button();
        Color4 = new Button();

        //back button
        VBox backcol = new VBox();
        BackBtn.setPrefSize(100,50);
        BackBtn.setStyle("-fx-background-color:#FFA630");
        backcol.getChildren().add(BackBtn);
        backcol.setPadding(new Insets(10, 10, 10,10));

        //ok button
        VBox okcol = new VBox();
        ok.setPrefSize(100,50);
        ok.setStyle("-fx-background-color:#FFA630");
        okcol.getChildren().add(ok);
        okcol.setPadding(new Insets(10, 10, 10,10));

        //title of the page
        Text choose = new Text("           Simply drag and drop to choose" + "\n" + "            your character and the colour");

        choose.setStyle("-fx-font: normal italic 24 Trebuchet;"
                + "-fx-base: #AE3522; "
                + "-fx-text-fill: orange;");

        //left column
        VBox leftcol = new VBox();
        leftcol.setPadding(new Insets(10, 10, 10,10));

        //left column - Male Button
        Image male =  new Image("/sample/boy1.png");
        ImageView maleView = new ImageView(male);
        maleView.setFitHeight(80);
        maleView.setFitWidth(80);
        MaleBtn.setGraphic(maleView);
        MaleBtn.setStyle("-fx-background-color:#0FA3B1");
        MaleBtn.setId("M");

        //left column - Female Button
        Image female =  new Image("/sample/girl1.png");
        ImageView femaleView = new ImageView(female);
        femaleView.setFitHeight(80);
        femaleView.setFitWidth(80);
        FemaleBtn.setGraphic(femaleView);
        FemaleBtn.setStyle("-fx-background-color:#0FA3B1");
        FemaleBtn.setId("F");

        //left column - style of buttons
        MaleBtn.setPrefSize(100,100);
        FemaleBtn.setPrefSize(100,100);
        leftcol.getChildren().addAll(MaleBtn,FemaleBtn);

        //character view
        VBox character  = new VBox();
        Image imageboy =  new Image("/sample/boy1.png");
        imgView = new ImageView(imageboy);
        imgView.setFitHeight(300);
        imgView.setFitWidth(300);
        character.getChildren().addAll(imgView);
        character.setPadding(new Insets(50, 100, 50, 100));


        //right column
        VBox rightcol = new VBox();
        rightcol.setPadding(new Insets(10, 10, 10,10));

        //right column - color button - 1
        Image colorimg1 =  new Image("/sample/color1.png");
        ImageView colorview1 = new ImageView(colorimg1);
        colorview1.setFitHeight(40);
        colorview1.setFitWidth(80);
        Color1.setGraphic(colorview1);
        Color1.setId("color1");
        Color1.setStyle("-fx-background-color:#0FA3B1");

        //right column - color button - 2
        Image colorimg2 =  new Image("/sample/color2.png");
        ImageView colorview2 = new ImageView(colorimg2);
        colorview2.setFitHeight(40);
        colorview2.setFitWidth(80);
        Color2.setGraphic(colorview2);
        Color2.setId("color2");
        Color2.setStyle("-fx-background-color:#0FA3B1");

        //right column - color button - 3
        Image colorimg3 =  new Image("/sample/color3.png");
        ImageView colorview3 = new ImageView(colorimg3);
        colorview3.setFitHeight(40);
        colorview3.setFitWidth(80);
        Color3.setGraphic(colorview3);
        Color3.setId("color3");
        Color3.setStyle("-fx-background-color:#0FA3B1");

        //right column - color button - 4
        Image colorimg4 =  new Image("/sample/color4.png");
        ImageView colorview4 = new ImageView(colorimg4);
        colorview4.setFitHeight(40);
        colorview4.setFitWidth(80);
        Color4.setGraphic(colorview4);
        Color4.setId("color4");
        Color4.setStyle("-fx-background-color:#0FA3B1");

        //right column - style of buttons
        Color1.setPrefSize(100,60);
        Color2.setPrefSize(100,60);
        Color3.setPrefSize(100,60);
        Color4.setPrefSize(100,60);
        rightcol.getChildren().addAll(Color1,Color2,Color3,Color4);
        rightcol.setSpacing(10);

        //add all
        this.add(leftcol,0,1);
        this.add(character,1,1);
        this.add(okcol,2,2);
        this.add(rightcol,2,1);
        this.add(choose, 1,0);
        this.add(backcol,0,0);
        this.setStyle("-fx-background-color:#0FA3B1");

    }
}
