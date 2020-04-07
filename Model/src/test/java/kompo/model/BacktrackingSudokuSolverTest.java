package kompo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BacktrackingSudokuSolverTest{
    @Test
    public void TestSolver() {
        
        SudokuBoard board = new SudokuBoard();
        
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        
        assertTrue(solver.solve(board));
        
        board.set(1, 2, board.get(2, 1));
        board.set(2, 1, 0);
        
        assertFalse(solver.solve(board));
        
        
    }
    @Test
    public void TestRow() {
        
        SudokuBoard board = new SudokuBoard();
        
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        
        board.set(1, 1, 1);

        assertTrue(solver.checkRow(1, 1, board));
        
        assertFalse(solver.checkRow(1, 2, board));
        
    }
    @Test
    public void TestColumn() {
        
        SudokuBoard board = new SudokuBoard();
        
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        
        board.set(1, 1, 1);

        assertTrue(solver.checkColumn(1, 1, board));
        
        assertFalse(solver.checkColumn(1, 2, board));
        
    }
    @Test
    public void TestBox() {
        
        SudokuBoard board = new SudokuBoard();
        
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        
        board.set(1, 1, 1);

        assertTrue(solver.checkBox3x3(1, 1, 1, board));
        
        assertFalse(solver.checkBox3x3(1, 1, 2, board));
        
    }
    
}
