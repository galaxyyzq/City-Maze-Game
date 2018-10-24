package controller;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.input.*;
import view.Characterpage;


public class charactercontroller {

    Characterpage cp;

    public charactercontroller(Characterpage cp){
        this.cp = cp;
    }

    public void init(){
        genderchange();
    }


    public void genderchange() {

        cp.FemaleBtn.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Dragboard db = cp.FemaleBtn.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putString(cp.FemaleBtn.getId());
                db.setContent(content);
                event.consume();
            }
        });

        cp.MaleBtn.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Dragboard db = cp.MaleBtn.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putString(cp.MaleBtn.getId());
                db.setContent(content);
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
                if (event.getDragboard().getContent(DataFormat.PLAIN_TEXT).equals("M")){
                    cp.imgView.setImage(new Image("/sample/boy.png"));
                }

                if (event.getDragboard().getContent(DataFormat.PLAIN_TEXT).equals("F")){
                    cp.imgView.setImage(new Image("/sample/girl.png"));
                }

                event.consume();
                event.setDropCompleted(true);
            }
        });




    }
}
