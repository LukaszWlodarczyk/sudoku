package kompo.model;


import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class FileSudokuBoardDao implements Dao<SudokuBoard>, AutoCloseable {
    
    String fileName;
    File file; 
    private Scanner reading;
    private PrintWriter writing;
    
    public FileSudokuBoardDao(final String fileName) {
        this.fileName = fileName;
        file = new File(fileName);
    }
    
    public SudokuBoard read() throws FileNotFoundException {
        
        SudokuBoard sudokuBoard = new SudokuBoard();
        
        if (file.exists()) {
            
            try {
                
                reading = new Scanner(file);
        
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        int value = Integer.parseInt(reading.nextLine());       
            
                        sudokuBoard.set(i, j, value);
                    }
                }
                
                reading.close();
                
            } catch (java.io.FileNotFoundException e) {
                System.out.print("Blad dostepu do pliku");
            }
        }
        
        return sudokuBoard;   
    }
    
    public boolean write(final SudokuBoard sudokuBoard) throws FileNotFoundException {

        try {
            writing = new PrintWriter(fileName);
            
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    writing.println(sudokuBoard.get(i, j));
                }
            }
            writing.close();
            return true;
            
        } catch (java.io.FileNotFoundException e) {
            System.out.print("Blad dostepu do pliku");
        }
        return false;

    }
    
    @Override
    public void finalize() throws IOException {
        try {
            reading.close();
            writing.close();
        } catch (Exception e) {
            // ...
        }
    }

    @Override
    public void close() throws Exception {
        try {
            reading.close();
            writing.close();
        } catch (Exception e) {
            // ...
        }
        
    }

}
