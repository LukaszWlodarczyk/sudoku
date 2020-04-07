package kompo.view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;
import kompo.model.*;

public class FormController implements Initializable {

    private final Logger logger = Logger.getLogger(FormController.class);
    private ResourceBundle texts;
    private int selectedRow;
    private int selectedColumn;
    private int[][] checkFlags = new int[9][9];
    // Holds this controller's Stage
    private Stage thisStage;
    private boolean checkBoardFlag = false;
    private SudokuBoard sudokuBoard;
    private BacktrackingSudokuSolver solver;
    private Level level;
    private Boolean loadFromFile = false;


    // Will hold a reference to the first controller, allowing us to access the methods found there.
    private final MenuController menuController;

    // Add references to the controls in form.fxml
    @FXML Button backToMenuButton;
    @FXML Button oneButton;
    @FXML Button twoButton;
    @FXML Button threeButton;
    @FXML Button fourButton;
    @FXML Button fiveButton;
    @FXML Button sixButton;
    @FXML Button sevenButton;
    @FXML Button eightButton;
    @FXML Button nineButton;
    @FXML Canvas canvas;
    @FXML Button checkBoardButton;
    @FXML Button saveButton;


    public FormController(final MenuController menuController) {
        // We received the first controller, now let's make it usable throughout this controller
        this.menuController = menuController;

        // Create the new stage
        thisStage = new Stage();

        // Load the FXML file
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("form.fxml"));

            // Set this class as the controller
            loader.setController(this);

            // Load the scene
            thisStage.setScene(new Scene(loader.load()));

            // Setup the window/stage
            thisStage.setTitle("Ekran Gry");

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





    @Override
    public void initialize(final URL arg0, final ResourceBundle arg1) {
        //checkBoardButton.setText();
        if (menuController.getLanguageFlagFlag() == 0) {
            texts = ResourceBundle.getBundle("textInGame", new Locale("pl"));
        } else if (menuController.getLanguageFlagFlag() == 1) {
            texts = ResourceBundle.getBundle("textInGame", new Locale("en"));
        }
        backToMenuButton.setText(texts.getString("back"));
        saveButton.setText(texts.getString("save"));
        checkBoardButton.setText(texts.getString("check"));
        backToMenuButton.setOnAction(event -> backToMenuPressed());
        oneButton.setOnAction(event -> onePressed());
        twoButton.setOnAction(event -> twoPressed());
        threeButton.setOnAction(event -> threePressed());
        fourButton.setOnAction(event -> fourPressed());
        fiveButton.setOnAction(event -> fivePressed());
        sixButton.setOnAction(event -> sixPressed());
        sevenButton.setOnAction(event -> sevenPressed());
        eightButton.setOnAction(event -> eightPressed());
        nineButton.setOnAction(event -> ninePressed());
        checkBoardButton.setOnAction(event -> checkBoardPressed());
        saveButton.setOnAction(event -> saveButtonPressed());
        canvas.setOnMousePressed(event -> canvasMouseClicked());


        sudokuBoard = new SudokuBoard();
        solver = new BacktrackingSudokuSolver();
        if (menuController.getFlag() == 1) {
            level = new Easy();
            logger.info("Zaladowano gre na poziomie latwy");
        } else if (menuController.getFlag() == 2) {
            level = new Medium();
            logger.info("Zaladowano gre na poziomie sredni");
        } else if (menuController.getFlag() == 3) {
            level = new Hard();
            logger.info("Zaladowano gre na poziomie trudny");
        } else if (menuController.getFlag() == 4) {
            try {
                loadingFromFile();
            } catch (MyException e) {
                logger.info("Moj wyjatek");
            }


        }

        selectedColumn=0;
        selectedRow=0;
        if (!loadFromFile) {
            solver.solve(sudokuBoard);
            level.removeFields(sudokuBoard);
        }
            //If checkFlags is 0, value was created by app, if 1 user did it.
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                checkFlags[col][row] = 0;
            }
        }

        GraphicsContext context = canvas.getGraphicsContext2D();
        drawOnCanvas(context);

    }


    @FXML
    public void backToMenuPressed() {
        this.thisStage.close();
    }
    @FXML
    public void onePressed() {
        if (sudokuBoard.get(selectedColumn, selectedRow) == 0 || checkFlags[selectedColumn][selectedRow] == 1) {
            sudokuBoard.set(selectedColumn, selectedRow, 1);
            checkFlags[selectedColumn][selectedRow]=1;
            drawOnCanvas(canvas.getGraphicsContext2D());
        }
    }
    @FXML
    public void twoPressed() {
        if (sudokuBoard.get(selectedColumn, selectedRow) == 0 || checkFlags[selectedColumn][selectedRow] == 1) {
            sudokuBoard.set(selectedColumn, selectedRow, 2);
            checkFlags[selectedColumn][selectedRow] = 1;
            drawOnCanvas(canvas.getGraphicsContext2D());
        }
    }
    @FXML
    public void threePressed() {
        if (sudokuBoard.get(selectedColumn, selectedRow) == 0 || checkFlags[selectedColumn][selectedRow] == 1) {
            sudokuBoard.set(selectedColumn, selectedRow, 3);
            checkFlags[selectedColumn][selectedRow] = 1;
            drawOnCanvas(canvas.getGraphicsContext2D());
        }
    }
    @FXML
    public void fourPressed() {
        if (sudokuBoard.get(selectedColumn, selectedRow) == 0 || checkFlags[selectedColumn][selectedRow] == 1) {
            sudokuBoard.set(selectedColumn, selectedRow, 4);
            checkFlags[selectedColumn][selectedRow] = 1;
            drawOnCanvas(canvas.getGraphicsContext2D());
        }
    }
    @FXML
    public void fivePressed() {
        if (sudokuBoard.get(selectedColumn, selectedRow) == 0 || checkFlags[selectedColumn][selectedRow] == 1) {
            sudokuBoard.set(selectedColumn, selectedRow, 5);
            checkFlags[selectedColumn][selectedRow] = 1;
            drawOnCanvas(canvas.getGraphicsContext2D());
        }
    }
    @FXML
    public void sixPressed() {
        if (sudokuBoard.get(selectedColumn, selectedRow) == 0 || checkFlags[selectedColumn][selectedRow] == 1) {
            sudokuBoard.set(selectedColumn, selectedRow, 6);
            checkFlags[selectedColumn][selectedRow] = 1;
            drawOnCanvas(canvas.getGraphicsContext2D());
        }
    }
    @FXML
    public void sevenPressed() {
        if (sudokuBoard.get(selectedColumn, selectedRow) == 0 || checkFlags[selectedColumn][selectedRow] == 1) {
            sudokuBoard.set(selectedColumn, selectedRow, 7);
            checkFlags[selectedColumn][selectedRow] = 1;
            drawOnCanvas(canvas.getGraphicsContext2D());
        }
    }
    @FXML
    public void eightPressed() {
        if (sudokuBoard.get(selectedColumn, selectedRow) == 0 || checkFlags[selectedColumn][selectedRow] == 1) {
            sudokuBoard.set(selectedColumn, selectedRow, 8);
            checkFlags[selectedColumn][selectedRow] = 1;
            drawOnCanvas(canvas.getGraphicsContext2D());
        }
    }
    @FXML
    public void ninePressed() {
        if (sudokuBoard.get(selectedColumn, selectedRow) == 0 || checkFlags[selectedColumn][selectedRow] == 1) {
            sudokuBoard.set(selectedColumn, selectedRow, 9);
            checkFlags[selectedColumn][selectedRow] = 1;
            drawOnCanvas(canvas.getGraphicsContext2D());
        }
    }
    @FXML
    public void checkBoardPressed() {
        checkBoardFlag=true;
        drawOnCanvas(canvas.getGraphicsContext2D());
    }
    @FXML
    public void saveButtonPressed() {
        try {
            sudokuToFile();
        } catch (FileNotFoundException e) {
            System.out.println("Blad zapisu?!");
        }
    }
    public void loadingFromFile() throws MyException {
        try {
            loadFromFile = true;
            sudokuBoard = (SudokuBoard) sudokuFromFile().clone();

        } catch (FileNotFoundException e) {
            logger.error("Nie znaleziono pliku.");
            throw new MyException(e.getMessage());

        } catch (CloneNotSupportedException e) {
            logger.error("Nie udalo sie sklonowac.");
        }
    }
    SudokuBoard sudokuFromFile() throws FileNotFoundException {
        FileSudokuBoardDao fromFile = new FileSudokuBoardDao("sudokuBoard.txt");
        return fromFile.read();
    }
    void sudokuToFile() throws FileNotFoundException {
        FileSudokuBoardDao toFile = new FileSudokuBoardDao("sudokuBoard.txt");
        toFile.write(sudokuBoard);
    }

    public void drawOnCanvas(final GraphicsContext context) {
        context.clearRect(0, 0, 450, 450);
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {


                //finds the y position of the cell, by multiplying the row number by 50, which is the height of a row
                int position_y = row * 50;

                // finds the x position of the cell, by multiplying the column number by 50, which is the width of a
                int position_x = col * 50;

                // defines the width of the square as 46 instead of 50, to account for the 4px total of blank space
                // as we are drawing squares, the height is going to be the same
                int width = 46;

                // set the fill color to white (you could set it to whatever you want)
                context.setFill(Color.CORNFLOWERBLUE);

                // draw a rounded rectangle with the calculated position and width. The last two arguments specify the
                // Play around with those if you want.
                context.fillRoundRect(position_x, position_y, width, width, 10, 10);
                context.setFill(Color.BLACK);
                context.setFont(new Font(20));
                if (sudokuBoard.get(col, row) != 0) {
                    context.fillText(sudokuBoard.getAsString(col, row), position_x + 20, position_y + 30);
                } else {
                    //context.setFill(Color.YELLOW);
                    //context.fillText(sudokuBoard.getAsString(row,col) , position_x+20, position_y+30);
                }
                // draw highlight around selected cell
                // set stroke color to res
                context.setStroke(Color.YELLOW);
                // set stroke width to 5px
                context.setLineWidth(5);
                // draw a strokeRoundRect using the same technique we used for drawing our board.

                context.strokeRoundRect(selectedColumn * 50 + 2, selectedRow * 50 + 2, 46, 46, 10, 10);
                if (checkBoardFlag) {
                    if (sudokuBoard.checkBoard()) {
                        if (checkFlags[col][row] == 1) {
                            context.setStroke(Color.GREEN);
                            context.strokeRoundRect(col * 50 + 2, row * 50 + 2, 46, 46, 10, 10);
                        }
                    } else {
                        if (checkFlags[col][row] == 1) {
                            context.setStroke(Color.RED);
                            context.strokeRoundRect(col * 50 + 2, row * 50 + 2, 46, 46, 10, 10);
                        }
                    }
                }
            }
        }
    }
    public void canvasMouseClicked() {
        // attach a new EventHandler of the MouseEvent type to the canvas
        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            // override the MouseEvent to do what we want it to do
            @Override
            public void handle(final MouseEvent event) {
                // intercept the mouse position relative to the canvas and cast it to an integer
                int mouse_x = (int) event.getX();
                int mouse_y = (int) event.getY();

                // convert the mouseX and mouseY into rows and cols
                // We are going to take advantage of the way integers are treated and we are going to divide
                //by a cell's width.
                // This way any value between 0 and 449 for x and y is going to give us an integer from
                //0 to 8, which is exactly what we are after.
                selectedRow = (int) (mouse_y / 50); // update player selected row
                selectedColumn = (int) (mouse_x / 50); // update player selected column

                //get the canvas graphics context and redraw
                drawOnCanvas(canvas.getGraphicsContext2D());
            }
        });
    }
}
