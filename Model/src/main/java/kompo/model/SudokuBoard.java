package kompo.model;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Arrays; 
import java.util.List;

public class SudokuBoard implements Cloneable{

    private List<SudokuField> board = Arrays.asList(new SudokuField[81]);
    private List<SudokuRow> rows = Arrays.asList(new SudokuRow[9]);
    private List<SudokuColumn> columns = Arrays.asList(new SudokuColumn[9]);
    private List<SudokuBox> boxes = Arrays.asList(new SudokuBox[9]);

    public SudokuBoard() {
        for (int i = 0; i < 81; i++) {
            board.set(i, new SudokuField());
        }
        
        for (int i = 0; i < 9; i++) {
            rows.set(i, new SudokuRow());
            columns.set(i, new SudokuColumn());
            boxes.set(i, new SudokuBox());
        }
        int pointer = 0;
        SudokuField[] tmp = new SudokuField[9];
        
        //initialize rows
        for (int i = 0; i < 9; i++) {
            
            for (int j = 0; j < 9; j++) {
                
                tmp[j] = board.get(pointer);
                pointer++;
                
            }
            rows.get(i).init(tmp);
        }
        
        //initialize columns     
        for (int i = 0; i < 9; i++) {
            
            pointer = i;
            
            for (int j = 0; j < 9; j++) {
                
                tmp[j] = board.get(pointer);
                pointer += 9;
            }
            columns.get(i).init(tmp);
        }
        
        int offset = 0;
        int jump = 0;
        //initialize boxes
        for (int i = 0; i < 9; i++) {
            
            if (i > 2) {
                jump = 1;
            }
            if (i > 5) {
                jump = 2;
            }
            if (i == 0 || i == 3 || i == 6) {
                offset = 0;
            } else if (i == 1 || i == 4 || i == 7) {
                offset = 1;
            } else {
                offset = 2;
            }
            
            pointer = 3 * offset + jump * 27;
            
            for (int j = 0; j < 3; j++) {
                
                tmp[j] = board.get(pointer);
                pointer++;  
            }
            pointer += 6;
            
            for (int j = 3; j < 6; j++) {
                
                tmp[j] = board.get(pointer);
                pointer++;  
            }
            pointer += 6;
            
            for (int j = 6; j < 9; j++) {
                
                tmp[j] = board.get(pointer);
                
                pointer++;  
            }
            boxes.get(i).init(tmp);
        }
        
    }
    
    void clear() {
        for (SudokuField field : board) {
            field.setFieldValue(0);
        }
    }
    
    public boolean checkBoard() {
        
        if (checkRow() && checkColumn() && checkBox()) {
            return true;
        } else {
            return false;
        }     
    }
    
    boolean checkRow() {

       for (int i = 0; i < rows.size(); i++) {
           if (!rows.get(i).verify()) {
               return false;
           }
       }
       return true;
    }
    
    boolean checkColumn() {
        
        for (int i = 0; i < columns.size(); i++) {
            if (!columns.get(i).verify()) {
                return false;
            }
        }
        return true;
    }
    
    boolean checkBox() {
        for (int i = 0; i < boxes.size(); i++) {
            if (!boxes.get(i).verify()) {
                return false;
            }
        }
        return true;
    }
    
    public int get(int x, int y) {
        return board.get(x + y * 9).getFieldValue();
    }

    public String getAsString(int x, int y) {

        String str=String.valueOf(board.get(x + y * 9).getFieldValue());
        return str;

    }
    
    public void set(int x, int y, int value) {
        board.get(x + y * 9).setFieldValue(value);
    }

    SudokuRow getRow(int x) {
        return rows.get(x);
    }
    
    SudokuColumn getColumn(int y) {
        return columns.get(y);
    }
    
    SudokuBox getBox(int x) {
        return boxes.get(x);
    }
    
    public int hashCode() {
        // you pick a hard-coded, randomly chosen, non-zero, odd number
        // ideally different for each class
        return new HashCodeBuilder(19, 37).
                append(board).
                append(rows).
                append(columns).
                append(boxes).
                toHashCode();
    }
    
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false; 
            }
        if (obj == this) {
            return true; 
            }
        if (obj.getClass() != getClass()) {
          return false;
        }
        
        SudokuBoard rhs = (SudokuBoard) obj;
        return new EqualsBuilder()
                      //.appendSuper(super.equals(obj))
                      .append(board, rhs.board)
                      .append(rows, rhs.rows)
                      .append(columns, rhs.columns)
                      .append(boxes, rhs.boxes)
                      .isEquals();
    }
    
    public String toString() {
        return new ToStringBuilder(this).
                append("board", board).
                append("rows", rows).
                append("columns", columns).
                append("boxes", boxes).
          toString();
    }

    void setField(int x, int y, final SudokuField fieldValue) {
        board.set(x + 9 * y, fieldValue);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        SudokuBoard sb = new SudokuBoard();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                sb.setField(i, j, (SudokuField) board.get(i + 9 * j).clone());
            }
        }
        return sb;
    }
}
