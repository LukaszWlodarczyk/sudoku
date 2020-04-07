package kompo.model;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class CloneableTest{
    @Test
    public void testCompare() throws CloneNotSupportedException {

        SudokuField field1 = new SudokuField(1);
        SudokuField field2 = (SudokuField) field1.clone();

        field2.setFieldValue(4);

        assertTrue(field1.getFieldValue() != field2.getFieldValue());

        SudokuRow sudokuRow = new SudokuRow();

        SudokuField[] fieldsArray = new SudokuField[9];

        for(int i = 0; i < 9; i++)
        {
            fieldsArray[i] = new SudokuField(0);
        }

        sudokuRow.init(fieldsArray);

        SudokuRow sudokuRow2 = (SudokuRow) sudokuRow.clone();

        assertTrue(sudokuRow.equals(sudokuRow2));

        SudokuField sf = new SudokuField(5);

        sudokuRow.setField(1, sf);

        assertFalse(sudokuRow.getField(1).equals(sudokuRow2.getField(1)));


    }

}