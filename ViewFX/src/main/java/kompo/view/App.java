package kompo.view;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX kompo.view.App
 */
public class App extends Application {

    public static void main(final String[] args) {
        launch(args);
    }
    @Override
    public void start(final Stage stage) throws IOException {
        // Create the first controller, which loads Layout1.fxml within its own constructor
        MenuController menuController = new MenuController();
        // Show the new stage
        menuController.showStage();
    }


}