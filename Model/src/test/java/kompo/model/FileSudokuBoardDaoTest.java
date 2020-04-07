package kompo.model;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.*;

public class FileSudokuBoardDaoTest {


    @Test
    public void TestWrite() throws FileNotFoundException {
        
        SudokuBoard sBoard = new SudokuBoard();
        
        FileSudokuBoardDao fSBD= new FileSudokuBoardDao("sudokuBoard.txt");
        
        BacktrackingSudokuSolver bSS = new BacktrackingSudokuSolver();
        
        bSS.solve(sBoard);
        
        assertTrue(fSBD.write(sBoard));
    }
    @Test
    public void TestRead() throws FileNotFoundException {
        
        SudokuBoard sBoard = new SudokuBoard();
        
        FileSudokuBoardDao fSBD = new FileSudokuBoardDao("sudokuBoard.txt");
        
        BacktrackingSudokuSolver bSS = new BacktrackingSudokuSolver();
        
        bSS.solve(sBoard);
        
        assertTrue(fSBD.write(sBoard));

        assertTrue(fSBD.read().equals(sBoard));
    }


}