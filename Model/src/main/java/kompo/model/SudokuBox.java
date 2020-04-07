package kompo.model;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SudokuBox extends SudokuPart implements Cloneable {

    public int hashCode() {
        // you pick a hard-coded, randomly chosen, non-zero, odd number
        // ideally different for each class
        return new HashCodeBuilder(19, 17).
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
        
        SudokuBox rhs = (SudokuBox) obj;
        return new EqualsBuilder()
               // .appendSuper(super.equals(obj))
                .isEquals();
    }
    
    public String toString() {
        return new ToStringBuilder(this).
          toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        SudokuRow srTmp = new SudokuRow();

        //List<SudokuField> fieldsTmp = Arrays.asList(new SudokuField[9]);
        SudokuField[] fieldsTmp = new SudokuField[9];

        for (int i = 0; i < 9; i++) {
            //fieldsTmp.set(i, fields.get(i).clone());
            fieldsTmp[i] = (SudokuField) fields.get(i).clone();
        }

        srTmp.init(fieldsTmp);


        return srTmp;
    }
}
