package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.*;
import sun.jvm.hotspot.debugger.Page;

public class MazeApp extends Application {

    public static void main(String[] args) { Application.launch(args); }


    public void start(Stage primaryStage) {

        primaryStage.setTitle("CityMaze");

        Gamepage gp = new Gamepage();
        Menupage mp = new Menupage();
        Characterpage cp = new Characterpage();
        Launchpage lp = new Launchpage();
        Mappage map = new Mappage();

        Scene GameScene = new Scene(gp,800,600);
        gp.initial();
        Scene MenuScene = new Scene(mp,800,600);
        mp.initial();
        Scene CharacterScene = new Scene(cp,800,600);
        cp.initial();
        Scene LaunchScene = new Scene(lp,800,600);
        lp.initial();
        Scene MapScene = new Scene(map,800,600);
        map.initial();

        lp.Startgame.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            primaryStage.setScene(CharacterScene);

        });

        cp.ok.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            primaryStage.setScene(MapScene);

        });

        map.start.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            primaryStage.setScene(GameScene);
            gp.setTime();

        });

        gp.menu.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            primaryStage.setScene(MenuScene);

        });

        gp.menu.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            primaryStage.setScene(MenuScene);

        });

        lp.exit.addEventHandler(MouseEvent.MOUSE_CLICKED,event -> {

                    Platform.exit();
        });

        mp.exit.addEventHandler(MouseEvent.MOUSE_CLICKED,event -> {

                    Platform.exit();
        });

        primaryStage.setScene(LaunchScene);
        primaryStage.show();

    }

}