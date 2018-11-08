package controller;



import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import view.Characterpage;
import view.Gamepage;
import view.Launchpage;
import view.Mappage;
import view.Menupage;
import model.Character;


public class MazeApp extends Application {

    public Character character;

    public static void main(String[] args) { Application.launch(args); }


    public void start(Stage primaryStage) {

        primaryStage.setTitle("CityMaze");

        Gamepage gp = new Gamepage();
        Menupage mp = new Menupage();
        Characterpage cp = new Characterpage();
        character = new Character("M", "color1", new Image("/sample/boy1.png"));
        controller.charactercontroller cpctrl = new charactercontroller(cp, character);
        Launchpage lp = new Launchpage();
        view.Mappage map = new Mappage();

        Scene GameScene = new Scene(gp,800,600);

        Scene MenuScene = new Scene(mp,800,600);
        mp.initial();
        Scene CharacterScene = new Scene(cp,800,600);
        cp.initial();
        cpctrl.init();
        Scene LaunchScene = new Scene(lp,800,600);
        lp.initial();
        Scene MapScene = new Scene(map,800,600);
        //map.initial(cpctrl.character);

        lp.Startgame.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            primaryStage.setScene(CharacterScene);

        });

        cp.ok.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            primaryStage.setScene(MapScene);
            map.initial(cpctrl.character);

        });

        map.start.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            primaryStage.setScene(GameScene);
            gp.initial(cpctrl.character);
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