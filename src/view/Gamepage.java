package view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import java.util.Timer;
import java.util.TimerTask;
import model.Character;
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
    public int[][] mazeArray;


    public void initial(Character ch) {


        time = 60;

        mazeArray = new int[][]{{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, -1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};


        GridPane gp = new GridPane();
        Button[][] mazeButton = new Button[mazeArray.length][mazeArray[1].length];

        for (int i = 0; i < mazeArray.length; i++) {
            for (int j = 0; j < mazeArray[i].length; j++) {
                mazeButton[i][j] = new Button();
                mazeButton[i][j].setPrefSize(30,25);
                if (mazeArray[i][j] == 0) {
                    mazeButton[i][j].setStyle("-fx-background-color: #0FA3B1;");
                } else {
                    mazeButton[i][j].setStyle("-fx-background-color: #ffffff;");
                }
                if(mazeArray[i][j] == -1){
                    mazeButton[i][j].setStyle("-fx-background-color: #ffffff;");
                    mazeButton[i][j].setGraphic(new ImageView(new Image("/sample/flag.png")));
                    mazeButton[i][j].setPadding(new Insets(0));
                }
                pos[i][j] = new Label();
                sp[i][j] = new StackPane(mazeButton[i][j], pos[i][j]);
                gp.add(sp[i][j], i, j);
            }
        }
        mtimer = new Label("Remain Time:\n");
        Text money = new Text("money: 1800");


        HBox header = new HBox(200);
        header.setPrefHeight(30);
        header.getChildren().addAll(menu, mtimer, money);
        header.getAlignment();


        this.setPadding(new Insets(10, 20, 10, 20));
        this.setCenter(gp);
        this.setTop(header);
        this.setStyle("-fx-background-color:#FFFFFF");


        play(ch);
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
                        timer.cancel();
                        Alert tim = new Alert(Alert.AlertType.CONFIRMATION);
                        tim.setContentText("Time is up!");
                        tim.showAndWait();
                    }

                }
            }, 0, 1000);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void play(Character ch) {

        drawCharacter(ch);
        this.setOnKeyPressed(event -> {
            handle(event);
            drawCharacter(ch);
        });

    }

    public void drawCharacter(Character ch) {
        ImageView avaview = new ImageView(ch.avatar);
        avaview.setFitHeight(25);
        avaview.setFitWidth(25);
        pos[posX][posY].setGraphic(avaview);
    }


    public void handle(KeyEvent e) {

        if (e.getCode() == KeyCode.W) {
            checkAndMove(0, -1);
        }
        if (e.getCode() == KeyCode.A) {
            checkAndMove(-1, 0);
        }
        if (e.getCode() == KeyCode.S) {
            checkAndMove(0, 1);
        }
        if (e.getCode() == KeyCode.D) {
            checkAndMove(1, 0);
        }

    }

    public void checkAndMove(int dx, int dy) {

        int x = posX + dx;
        int y = posY + dy;
        Alert alt = new Alert(Alert.AlertType.CONFIRMATION);
        alt.setContentText("You win!");
        if (x < 0 || x >= 19 || y < 0 || y >= 19) return;
        if (mazeArray[x][y]==1) {
            pos[posX][posY].setGraphic(null);
            posX = x;
            posY = y;
        }
        if(mazeArray[x][y]==-1){
            alt.showAndWait();
        }
    }


}


