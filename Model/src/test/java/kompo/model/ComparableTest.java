package kompo.model;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ComparableTest{
    @Test
    public void testCompare() {

        SudokuField field1 = new SudokuField(1);
        SudokuField field2 = new SudokuField(2);
        SudokuField field3 = new SudokuField(3);

        assertEquals(field1.compareTo(field2), -1);
        assertEquals(field3.compareTo(field2), 1);
        assertEquals(field2.compareTo(field2), 0);

    }

}