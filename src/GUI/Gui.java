package GUI;

import Environment.Popolazione;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by max on 20/06/17.
 */
public class Gui extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    private static Stage stage;
    private static Popolazione popolazione;

    public static Stage getStage() { return stage; }
    public static void setPopolazione(Popolazione pop) { popolazione = pop; }

    @Override
    public void start(Stage primaryStage){
        stage = primaryStage;
        primaryStage.show();
        MainMenu.MainMenu();
    }
}
