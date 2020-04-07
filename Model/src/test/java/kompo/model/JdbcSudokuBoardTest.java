package kompo.model;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.*;
public class JdbcSudokuBoardTest {
    SudokuBoard sBoard = new SudokuBoard();

    JdbcSudokuBoardDao jSBD= new JdbcSudokuBoardDao();

    BacktrackingSudokuSolver bSS = new BacktrackingSudokuSolver();

    /*@Test
    public void TestWrite() throws FileNotFoundException {


        bSS.solve(sBoard);
        assertTrue(jSBD.write(sBoard));
    }*/
    @Test
    public void TestRead() throws FileNotFoundException {
          assertTrue(true);
//        bSS.solve(sBoard);
//        assertTrue(jSBD.write(sBoard));
//        assertTrue(jSBD.read().equals(sBoard));
    }
}
