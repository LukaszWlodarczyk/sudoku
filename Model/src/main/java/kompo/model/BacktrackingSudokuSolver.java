package kompo.model;


import java.util.Arrays;
import java.util.Random;

public class BacktrackingSudokuSolver implements SudokuSolver {

    @Override
    public boolean solve(final SudokuBoard board) {
        if (checkFieldAndPutNumber(board)) {
            return true;
        } else {
            return false;
        }
    }
    
    boolean checkFieldAndPutNumber(final SudokuBoard board) {
        
        //row, column, box
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.get(i, j) == 0) {

                    int[] arrayWithRandomNumbers = new int[9];
                    Arrays.fill(arrayWithRandomNumbers, 0);
                    for (int k = 0; k < arrayWithRandomNumbers.length; k++) {
                        arrayWithRandomNumbers[k] = getRandomNumber();
                        for (int l = 0; l < k; l++) {
                            if (arrayWithRandomNumbers[l] == arrayWithRandomNumbers[k]) {
                                k--; 
                            }
                        }
                    }
                    
                    for (int k = 0; k < 9; k++) {
                        if (!(checkRow(i, arrayWithRandomNumbers[k], board) || checkColumn(j, arrayWithRandomNumbers[k], board) || checkBox3x3(i, j, arrayWithRandomNumbers[k], board))) {
                            board.set(i, j, arrayWithRandomNumbers[k]);
                            if (checkFieldAndPutNumber(board)) {
                                return true;
                            } else {
                                board.set(i, j, 0);
                            }
                        }
                    }
                    
                    return false;
                }
            }
        }
        
        
        return true;
    }
    
    
    boolean checkRow(int row, int number, final SudokuBoard board) {
        
        for (int i = 0; i < 9; i++) {
            if (board.get(row, i) == number) {
                return true;
            }
        }
        
        return false;
    }
    
    boolean checkColumn(int column, int number, final SudokuBoard board) {
        
        for (int i = 0; i < 9; i++) {
            if (board.get(i, column) == number) {
                return true;
            }
        }
        
        return false;
    }
    
    boolean checkBox3x3(int row, int column, int number, final SudokuBoard board) {
        
        int rowInBox = row - row % 3;
        int columnInBox = column - column % 3;
        
        for (int i = rowInBox; i < rowInBox + 3; i++) {
            for (int j = columnInBox; j < columnInBox + 3; j++) {
                if (board.get(i, j) == number) {
                    return true;
                }
            }
        }
        
        return false;
    }
    

    int getRandomNumber() {
    
        Random rand = new Random();
        
        return rand.nextInt(9) + 1;
    }

}
