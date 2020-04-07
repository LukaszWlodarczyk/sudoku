package kompo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuBoardTest {

    @Test
    public void TestBoard() {
        
        SudokuBoard board = new SudokuBoard();
        
        //testing init
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                assertTrue(board.get(i, j) == 0);
            }
        }
        
        //get and set
        board.set(5, 5, 2);
        
        assertTrue(board.get(5, 5) == 2);
        
        
        //checkBoard
        SudokuSolver solver = new BacktrackingSudokuSolver();
        
        board.clear();
        solver.solve(board);
        
        assertTrue(board.checkBoard());
        
        board.set(1, 1, 1);
        board.set(2, 1, 1);
        board.set(3, 1, 1);
        
        assertFalse(board.checkBoard());
        assertFalse(board.checkRow());
        
        board.clear();
        solver.solve(board);
        
        board.set(1, 1, 1);
        board.set(1, 2, 1);
        board.set(1, 3, 1);
        
        assertFalse(board.checkBoard());
        assertFalse(board.checkColumn());
        
        board.clear();
        solver.solve(board);
        
        
        board.set(0, 0, 1);
        board.set(1, 1, 1);
        board.set(2, 2, 1);
        
        assertFalse(board.checkBoard());
        assertFalse(board.checkBox());
        
        board.clear();     
        
        SudokuBoard board2 = new SudokuBoard();
        
        
        assertTrue(board.equals(board2));
        assertTrue(board.hashCode() == board2.hashCode());
        
        board.clear();
        board2.clear();
        
        /*System.out.print(board.hashCode());
        System.out.print('\n');
        System.out.print(board2.hashCode());*/
        
        //System.out.print(board.equals(board2));
        
        assertTrue(board.equals(board2));
        board.set(0, 0, 1);
        assertFalse(board.equals(board2));
        
        SudokuField field = new SudokuField();
        SudokuField field2 = new SudokuField();
                
        assertTrue(field.equals(field2));
        assertTrue(field.hashCode() == field2.hashCode());
        field.setFieldValue(3);
        assertFalse(field.equals(field2));
    }

    
}
