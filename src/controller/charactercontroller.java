package controller;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.input.*;
import view.Characterpage;
import model.Character;


public class charactercontroller {

    Characterpage cp;
    Character character;

    public charactercontroller(Characterpage cp, Character character){
        this.cp = cp;
        this.character=character;
    }

    public void init(){
        genderchange();
        colorchange();
    }


    public void genderchange() {

        cp.FemaleBtn.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Dragboard db = cp.FemaleBtn.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putImage(new Image("/sample/girl1.png"));
                db.setContent(content);
                System.out.println(character.gender);
                character.gender = cp.FemaleBtn.getId();
                setAvatar();
                event.consume();
            }
        });

        cp.MaleBtn.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Dragboard db = cp.MaleBtn.startDragAndDrop(TransferMode.MOVE);
                character.gender = cp.MaleBtn.getId();
                ClipboardContent content = new ClipboardContent();
                content.putImage(new Image("/sample/boy1.png"));
                db.setContent(content);
                System.out.println(character.gender);
                character.gender = cp.MaleBtn.getId();
                setAvatar();
                event.consume();
            }
        });


        cp.imgView.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                event.acceptTransferModes(TransferMode.MOVE);
                event.consume();
            }
        });

        cp.imgView.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                setAvatar();
                event.consume();
                event.setDropCompleted(true);
            }
        });

    }

    public void colorchange() {


        cp.Color1.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Dragboard db = cp.Color1.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putImage(new Image("/sample/color1.png"));
                db.setContent(content);
                character.color = cp.Color1.getId();
                System.out.println(character.color);
                System.out.println(character.gender);
                setAvatar();
                event.consume();
            }
        });

        cp.Color2.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Dragboard db = cp.Color2.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putImage(new Image("/sample/color2.png"));
                db.setContent(content);
                character.color = cp.Color2.getId();
                System.out.println(character.color);
                System.out.println(character.gender);
                setAvatar();
                event.consume();
            }
        });

        cp.Color3.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Dragboard db = cp.Color3.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putImage(new Image("/sample/color3.png"));
                db.setContent(content);
                character.color = cp.Color3.getId();
                System.out.println(character.color);
                System.out.println(character.gender);
                setAvatar();
                event.consume();
            }
        });

        cp.Color4.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Dragboard db = cp.Color4.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putImage(new Image("/sample/color4.png"));
                db.setContent(content);
                character.color = cp.Color4.getId();
                System.out.println(character.color);
                System.out.println(character.gender);
                setAvatar();
                event.consume();
            }
        });

        cp.imgView.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                event.acceptTransferModes(TransferMode.MOVE);
                event.consume();
            }
        });

        cp.imgView.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                setAvatar();
                event.consume();
                event.setDropCompleted(true);
            }
        });

    }


    public void setAvatar(){
        if (character.gender == "M") {

            if (character.color == "color1") {
                character.avatar = new Image("/sample/boy1.png");

            }
            if (character.color == "color2") {
                character.avatar = new Image("/sample/boy2.png");

            }
            if (character.color == "color3") {
                character.avatar = new Image("/sample/boy3.png");

            }
            if (character.color == "color4") {
                character.avatar = new Image("/sample/boy4.png");

            }

        }
        if (character.gender == "F"){

            if (character.color == "color1") {
                character.avatar = new Image("/sample/girl1.png");
            }
            if (character.color == "color2") {
                character.avatar = new Image("/sample/girl2.png");
            }
            if (character.color == "color3") {
                character.avatar = new Image("/sample/girl3.png");
            }
            if (character.color == "color4") {
                character.avatar = new Image("/sample/girl4.png");
            }

        }


        cp.imgView.setImage(character.avatar);
    }


}
