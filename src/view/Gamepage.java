package view;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import java.util.Timer;
import java.util.TimerTask;
import model.Character;
import model.Money;
import model.Worldmap;

public class Gamepage extends BorderPane {

    public Button menu = new Button("menu");
    public Timer timer;
    public Label[][] pos = new Label[20][20];
    int posX = 0;
    int posY = 0;
    public StackPane[][] sp = new StackPane[20][20];
    private int time;
    private Label mtimer;
    public Button[][] mazeButton;
    Money money;
    Worldmap worldmap;

    public Gamepage(Money money, Worldmap worldmap){
        this.money = money;
        this.worldmap =worldmap;
    }


    public void initial(Character ch, Money money, Worldmap worldmap) {


        time = 40;

        menu.setPrefSize(100,50);
        menu.setStyle("-fx-background-color:#FFA630");


        GridPane gp = new GridPane();
        mazeButton = new Button[worldmap.mazeArray.length][worldmap.mazeArray[1].length];

        for (int i = 0; i < worldmap.mazeArray.length; i++) {
            for (int j = 0; j < worldmap.mazeArray[i].length; j++) {
                mazeButton[i][j] = new Button();
                mazeButton[i][j].setPrefSize(30,25);
                if (worldmap.mazeArray[i][j] == 0 ) {
                    mazeButton[i][j].setStyle("-fx-background-color: #0FA3B1;");
                } else {
                    mazeButton[i][j].setStyle("-fx-background-color: #ffffff;");
                }
                if(worldmap.mazeArray[i][j] == -1){
                    mazeButton[i][j].setStyle("-fx-background-color: #ffffff;");
                    mazeButton[i][j].setGraphic(new ImageView(new Image("/sample/flag.png")));
                    mazeButton[i][j].setPadding(new Insets(0));
                }
                if(worldmap.mazeArray[i][j] == 2){
                    mazeButton[i][j].setGraphic(new ImageView(worldmap.cityimage));
                    mazeButton[i][j].setPadding(new Insets(0));
                }
                pos[i][j] = new Label();
                sp[i][j] = new StackPane(mazeButton[i][j], pos[i][j]);
                gp.add(sp[i][j], i, j);
            }
        }
        mtimer = new Label("Remain Time:\n");
        Text moneytext = new Text("money: "+money.moneynum);


        HBox header = new HBox(200);
        header.setPrefHeight(30);
        header.getChildren().addAll(menu, mtimer, moneytext);
        header.getAlignment();

        VBox playinst = new VBox(10);
        Text playinsttexttitle = new Text("HOW TO PLAY");
        Text playinsttext = new Text("A = move left" + "\n" + "D = move right" + "\n" + "S = move down"+ "\n" +"W = move up");
        playinsttext.setStyle("-fx-font: normal 14 Trebuchet;"
                + "-fx-base: #AE3522; "
                + "-fx-text-fill: orange;");

        playinsttexttitle.setStyle("-fx-font: normal bold 20 Trebuchet;"
                + "-fx-base: #AE3522; "
                + "-fx-text-fill: orange;");
        playinst.setStyle("-fx-background-color:#FFA630");
        playinst.setMaxHeight(20);
        playinst.setPadding(new Insets(10,10,10,10));
        playinst.getChildren().addAll(playinsttexttitle,playinsttext);
        playinst.setAlignment(Pos.CENTER);

        this.setPadding(new Insets(10, 20, 10, 20));
        this.setCenter(gp);
        this.setTop(header);
        this.setRight(playinst);
        this.setStyle("-fx-background-color:#FFFFFF");


        play(ch,worldmap,money);
    }



    public void setTime() {
        try {

            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            mtimer.setText("Remain Time:\n" + time);

                        }
                    });
                    time--;

                    if (time == 0) {
                        Platform.runLater(()->{

                            timer.cancel();
                            Alert tim = new Alert(Alert.AlertType.CONFIRMATION);
                            tim.setContentText("Time is up!");
                            tim.showAndWait();
                            //primaryStage.setScene(LaunchScene);

                        });

                    }

                }
            }, 0, 1000);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void play(Character ch, Worldmap worldmap, Money money) {

        drawCharacter(ch);
        this.setOnKeyPressed(event -> {
            handle(event, worldmap, money);
            drawCharacter(ch);
        });

    }

    public void drawCharacter(Character ch) {
        ImageView avaview = new ImageView(ch.avatar);
        avaview.setFitHeight(25);
        avaview.setFitWidth(25);
        pos[posX][posY].setGraphic(avaview);
    }


    public void handle(KeyEvent e, Worldmap worldmap, Money money) {

        if (e.getCode() == KeyCode.W) {
            checkAndMove(0, -1, worldmap, money);
        }
        if (e.getCode() == KeyCode.A) {
            checkAndMove(-1, 0, worldmap, money);
        }
        if (e.getCode() == KeyCode.S) {
            checkAndMove(0, 1, worldmap, money);
        }
        if (e.getCode() == KeyCode.D) {
            checkAndMove(1, 0, worldmap,money);
        }

    }

    public void checkAndMove(int dx, int dy, Worldmap worldmap, Money money) {

        int x = posX + dx;
        int y = posY + dy;
        Alert alt = new Alert(Alert.AlertType.CONFIRMATION);
        alt.setContentText("You win!");
        if (x < 0 || x > 19 || y < 0 || y > 19) return;
        if (worldmap.mazeArray[x][y]==1) {
            pos[posX][posY].setGraphic(null);
            posX = x;
            posY = y;
        }
        if(worldmap.mazeArray[x][y]==2){
            pos[posX][posY].setGraphic(null);
            mazeButton[x][y].setGraphic(null);
            money.moneynum = money.moneynum+100;
            posX = x;
            posY = y;
        }
        if(worldmap.mazeArray[x][y]==-1){
            alt.showAndWait();
        }
    }

    public void moneychange(){}


}


