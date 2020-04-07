package kompo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelTest {
    SudokuBoard sudokuBoard = new SudokuBoard();
    BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
    int zeroFields;

    @Test
    void removeFieldsTestEasy() {
        Easy easy = new Easy();
        zeroFields = 0;
        solver.solve(sudokuBoard);
        easy.removeFields(sudokuBoard);
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if (sudokuBoard.get(i,j)==0) {
                    zeroFields++;
                }
            }
        }
        Assertions.assertEquals(15,zeroFields);
    }
    @Test
    void removeFieldsTestMedium() {
        Medium medium = new Medium();
        zeroFields = 0;
        solver.solve(sudokuBoard);
        medium.removeFields(sudokuBoard);
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if (sudokuBoard.get(i,j)==0) {
                    zeroFields++;
                }
            }
        }
        Assertions.assertEquals(30,zeroFields);
    }
    @Test
    void removeFieldsTestHard() {
        Hard hard = new Hard();
        zeroFields = 0;
        solver.solve(sudokuBoard);
        hard.removeFields(sudokuBoard);
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if (sudokuBoard.get(i,j)==0) {
                    zeroFields++;
                }
            }
        }
        Assertions.assertEquals(45,zeroFields);
    }
}