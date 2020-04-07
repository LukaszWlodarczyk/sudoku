package kompo.view;


import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kompo.model.Authors;

public class MenuController {
    private Integer flag;
    private Integer languageFlag = 0;
    Locale defLoc = new Locale("pl");
    ResourceBundle texts;
    //ResourceBundle authors;
    Authors aut;
    // Holds this controller's Stage
    private final Stage thisStage;
    // Define the nodes from the Layout1.fxml file. This allows them to be referenced within the controller
    @FXML
    private Button easyButton;
    @FXML
    private Button mediumButton;
    @FXML
    private Button hardButton;
    @FXML
    private Button loadButton;
    @FXML
    private Button languageButton;
    @FXML
    private Label newGameLabel;
    @FXML
    private Label loadGameLabel;
    @FXML
    private Label authorsLabel1;
    @FXML
    private Label authorsLabel2;
    @FXML
    private Label authorsLabel;

    public MenuController() {
        //Create new stage
        thisStage = new Stage();

        //Load the FMXL file
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));

            // Set this class as the controller
            loader.setController(this);

            // Load the scene
            thisStage.setScene(new Scene(loader.load()));

            // Setup the window/stage
            thisStage.setTitle("Menu Glowne");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Show the stage that was loaded in the constructor
     */
    public void showStage() {
        thisStage.showAndWait();
    }

    /**
     * The initialize() method allows you set setup your scene, adding actions, configuring nodes, etc.
     */
    private void openForm(final Integer levelFlag, final Integer languageFlag) {

        // Create the second controller, which loads its own FXML file. We pass a reference to this controller
        // using the keyword [this]; that allows the second controller to access the methods contained in here.
        setFlag(levelFlag);
        FormController formController = new FormController(this);

        // Show the new stage/window
        formController.showStage();


    }
    /**
     * The initialize() method allows you set setup your scene, adding actions, configuring nodes, etc.
     */
    @FXML
    private void initialize() {
        texts = ResourceBundle.getBundle("textMenu", defLoc);
        aut = new Authors();
        //authors = ResourceBundle.getBundle("Authors",defLoc);

        easyButton.setText(texts.getString("easy"));
        mediumButton.setText(texts.getString("medium"));
        hardButton.setText(texts.getString("hard"));
        loadButton.setText(texts.getString("load"));
        newGameLabel.setText(texts.getString("newGameLabel"));
        loadGameLabel.setText(texts.getString("loadGameLabel"));
        languageButton.setText(texts.getString("language"));
        authorsLabel.setText(texts.getString("authors"));
        authorsLabel1.setText(aut.getString("author1"));
        authorsLabel2.setText(aut.getString("author2"));


        // Add an action for the "Open Layout2" button
        easyButton.setOnAction(event -> openForm(1, languageFlag));
        mediumButton.setOnAction(event -> openForm(2, languageFlag));
        hardButton.setOnAction(event -> openForm(3, languageFlag));
        loadButton.setOnAction(event -> openForm(4, languageFlag));
        languageButton.setOnAction(event -> changeLanguage());


    }
    public void changeLanguage() {
        if (languageFlag == 0) {
            defLoc = new Locale("en");
            //Locale.setDefault(new Locale("en"));
            languageFlag = 1;
            initialize();
        } else if (languageFlag == 1) {
            defLoc = new Locale("pl");
            //Locale.setDefault(new Locale("pl"));
            languageFlag = 0;
            initialize();
        }
    }

    public Integer getFlag() {
        return this.flag;
    }

    public void setFlag(final Integer flag) {
        this.flag = flag;
    }

    public Integer getLanguageFlagFlag() {
        return this.languageFlag;
    }
}
