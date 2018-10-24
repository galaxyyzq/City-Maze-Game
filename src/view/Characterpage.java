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
	public Button MaleBtn = new Button();
	public Button FemaleBtn;// = new Button();
	public ImageView imgView;


	public void initial() {



		FemaleBtn = new Button();

	    //back button
        VBox backcol = new VBox();
        BackBtn.setPrefSize(100,30);
        backcol.getChildren().add(BackBtn);
        backcol.setPadding(new Insets(10, 10, 10,10));

	    //ok button
        VBox okcol = new VBox();
        ok.setPrefSize(100,30);
        okcol.getChildren().add(ok);
        okcol.setPadding(new Insets(10, 10, 10,10));

        //title of the page
        Text choose = new Text("Customize your character by drag and drop");
        choose.setStyle("-fx-font: normal bold 26 Langdon; "
                + "-fx-base: #AE3522; "
                + "-fx-text-fill: orange;");

        //left column
		VBox leftcol = new VBox();
        leftcol.setPadding(new Insets(10, 10, 10,10));

        //left column - Male Button
		Image male =  new Image("/sample/boy.png");
		ImageView maleView = new ImageView(male);
		maleView.setFitHeight(50);
		maleView.setFitWidth(50);
		MaleBtn.setGraphic(maleView);
		MaleBtn.setId("M");

		//left column - Female Button
		Image female =  new Image("/sample/girl.png");
		ImageView femaleView = new ImageView(female);
		femaleView.setFitHeight(50);
		femaleView.setFitWidth(50);
		FemaleBtn.setGraphic(femaleView);
		FemaleBtn.setId("F");

        //left column - style of buttons
		MaleBtn.setPrefSize(100,100);
		FemaleBtn.setPrefSize(100,100);
        leftcol.getChildren().addAll(MaleBtn,FemaleBtn);

        //character view
		VBox character  = new VBox();
		Image imageboy =  new Image("/sample/boy.png");
		imgView = new ImageView(imageboy);
		imgView.setFitHeight(300);
		imgView.setFitWidth(300);
		character.getChildren().addAll(imgView);
		character.setPadding(new Insets(30, 30, 30, 30));




        //right column
        VBox rightcol = new VBox();
        rightcol.setPadding(new Insets(10, 10, 10,10));

        //right column - color button - 1
        Image colorimg1 =  new Image("/sample/color1.png");
        ImageView colorview1 = new ImageView(colorimg1);
        colorview1.setFitHeight(30);
        colorview1.setFitWidth(70);
        Button Color1 = new Button();
        Color1.setGraphic(colorview1);
        Color1.setId("color1");

        //right column - color button - 2
        Image colorimg2 =  new Image("/sample/color2.png");
        ImageView colorview2 = new ImageView(colorimg2);
        colorview2.setFitHeight(30);
        colorview2.setFitWidth(70);
        Button Color2 = new Button();
        Color2.setGraphic(colorview2);
        Color2.setId("color2");

        //right column - color button - 3
        Image colorimg3 =  new Image("/sample/color3.png");
        ImageView colorview3 = new ImageView(colorimg3);
        colorview3.setFitHeight(30);
        colorview3.setFitWidth(70);
        Button Color3 = new Button();
        Color3.setGraphic(colorview3);
        Color3.setId("color3");

        //right column - color button - 4
        Image colorimg4 =  new Image("/sample/color4.png");
        ImageView colorview4 = new ImageView(colorimg4);
        colorview4.setFitHeight(30);
        colorview4.setFitWidth(70);
        Button Color4 = new Button();
        Color4.setGraphic(colorview4);
        Color4.setId("color4");

        //right column - style of buttons
        Color1.setPrefSize(100,60);
        Color2.setPrefSize(100,60);
        Color3.setPrefSize(100,60);
        Color4.setPrefSize(100,60);
        rightcol.getChildren().addAll(Color1,Color2,Color3,Color4);




		//add all
		this.add(leftcol,0,1);
		this.add(character,1,1);
		this.add(okcol,2,2);
        this.add(rightcol,2,1);
		this.add(choose, 1,0);
		this.add(backcol,0,0);



        //drag and drop function to change gender
//		FemaleBtn.setOnDragDetected(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				Dragboard db = FemaleBtn.startDragAndDrop(TransferMode.MOVE);
//				ClipboardContent content = new ClipboardContent();
//				content.putString(FemaleBtn.getId());
//				db.setContent(content);
//				event.consume();
//			}
//		});

//		MaleBtn.setOnDragDetected(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				Dragboard db = MaleBtn.startDragAndDrop(TransferMode.MOVE);
//				ClipboardContent content = new ClipboardContent();
//				content.putString(MaleBtn.getId());
//				db.setContent(content);
//				event.consume();
//			}
//		});
//
//		imgView.setOnDragOver(new EventHandler<DragEvent>() {
//			@Override
//			public void handle(DragEvent event) {
//				event.acceptTransferModes(TransferMode.MOVE);
//				event.consume();
//			}
//		});
//
//		imgView.setOnDragDropped(new EventHandler<DragEvent>() {
//			@Override
//			public void handle(DragEvent event) {
//				if (event.getDragboard().getContent(DataFormat.PLAIN_TEXT).equals("M")){
//					imgView.setImage(new Image("/sample/boy.png"));
//				}
//
//				if (event.getDragboard().getContent(DataFormat.PLAIN_TEXT).equals("F")){
//					imgView.setImage(new Image("/sample/girl.png"));
//				}
//
//				event.consume();
//				event.setDropCompleted(true);
//			}
//		});




	}
}
