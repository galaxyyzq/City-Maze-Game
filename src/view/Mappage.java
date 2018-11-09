package view;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import model.Character;
import model.Worldmap;

public class Mappage extends GridPane {

    public Button start = new Button("start");
    public Button imagebutton = new Button();
    public Label user = new Label("User");
    public Button bmapa = new Button();
    public Button bmapb = new Button();
    public Button bmapc = new Button();
    public Button bmapd = new Button();
    public Button bmape = new Button();
    public Button bmapf = new Button();
    Worldmap worldmap;

    public void initial(Character ch) {

        this.add(start, 2, 3);
        this.setStyle("-fx-background-color:#FFFFFF");

        start.setPrefSize(100,50);
        start.setStyle("-fx-background-color:#FFA630");

        imagebutton.setStyle("-fx-background-color:#FFFFFF");

        //This is the image of the world map1
        Image map1 = new Image("/sample/1.png");
        ImageView IVmapa = new ImageView(map1);
        bmapa.setGraphic(IVmapa);
        bmapa.setId("NY");
        this.add(IVmapa,1,0);

        //This is the image of the world map2
        Image map2 = new Image("/sample/2.png");
        ImageView IVmapb = new ImageView(map2);
        bmapb.setGraphic(IVmapb);
        bmapb.setId("Paris");
        this.add(IVmapb,2,0);

        //This is the image of the world map3
        Image map3 = new Image("/sample/3.png");
        ImageView IVmapc = new ImageView(map3);
        bmapc.setGraphic(IVmapc);
        bmapc.setId("SH");
        this.add(IVmapc,3,0);

        //This is the image of world map4
        Image map4 = new Image("/sample/4.png");
        ImageView IVmapd = new ImageView(map4);
        bmapd.setGraphic(IVmapd);
        bmapd.setId("Brasil");
        this.add(IVmapd,1,1);

        //This is the image of world map5
        Image map5 = new Image("/sample/5.png");
        ImageView IVmape = new ImageView(map5);
        bmape.setGraphic(IVmape);
        bmape.setId("Egypt");
        this.add(IVmape,2,1);

        //This is the image of world map6
        Image map6 = new Image("/sample/6.png");
        ImageView IVmapf = new ImageView(map6);
        bmapf.setGraphic(IVmapf);
        bmapf.setId("Sydney");
        this.add(IVmapf,3,1);

        //This is the image of the boy
        ImageView imageView = new ImageView();
        imageView.setImage(ch.avatar);
        System.out.println(ch.avatar);
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        imagebutton.setGraphic(imageView);
        imagebutton.setId("imagebutton");
        this.add(imagebutton, 0, 0);


        imagebutton.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event){
                Dragboard db = imagebutton.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putString(imagebutton.getId());
                db.setContent(content);
                event.consume();
            }
        });

        IVmapa.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                event.acceptTransferModes(TransferMode.MOVE);
                event.consume();
            }
        });

        IVmapa.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                IVmapa.setImage(new Image("/sample/1a.png"));
                imagebutton.setVisible(false);
                //worldmap.city = IVmapa.getId();
                event.consume();
                event.setDropCompleted(true);
            }
        });

        IVmapb.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                event.acceptTransferModes(TransferMode.MOVE);
                event.consume();
            }
        });

        IVmapb.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                IVmapb.setImage(new Image("/sample/2a.png"));
                imagebutton.setVisible(false);
                event.consume();
                event.setDropCompleted(true);
            }
        });

        IVmapc.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                event.acceptTransferModes(TransferMode.MOVE);
                event.consume();
            }
        });

        IVmapc.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                IVmapc.setImage(new Image("/sample/3a.png"));
                imagebutton.setVisible(false);
                event.consume();
                event.setDropCompleted(true);
            }
        });

        IVmapd.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                event.acceptTransferModes(TransferMode.MOVE);
                event.consume();
            }
        });

        IVmapd.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                IVmapd.setImage(new Image("/sample/4a.png"));
                imagebutton.setVisible(false);
                event.consume();
                event.setDropCompleted(true);
            }
        });


        IVmape.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                event.acceptTransferModes(TransferMode.MOVE);
                event.consume();
            }
        });

        IVmape.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                IVmape.setImage(new Image("/sample/5a.png"));
                imagebutton.setVisible(false);
                event.consume();
                event.setDropCompleted(true);
            }
        });

        IVmapf.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                event.acceptTransferModes(TransferMode.MOVE);
                event.consume();
            }
        });

        IVmapf.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                IVmapf.setImage(new Image("/sample/6a.png"));
                imagebutton.setVisible(false);
                event.consume();
                event.setDropCompleted(true);
            }
        });
    }

}