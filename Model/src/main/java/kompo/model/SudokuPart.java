package kompo.model;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SudokuPart {
    
    //SudokuField[] fields = new SudokuField[9];
    protected List<SudokuField> fields = Arrays.asList(new SudokuField[9]);
    
    //abstract boolean verify();
    
    boolean verify() {
        
        int expectedValue = 362880;
        int container = 1;
        
        for (SudokuField field : fields) {
            container *= field.getFieldValue();
        }
        
        if (expectedValue != container) {
            return false;
        }
        
        return true;
    }

    protected void init(final SudokuField[] values) {
        
        for (int i = 0; i < fields.size(); i++) {
            fields.set(i, values[i]);
        }
        
    }
    
    public int hashCode() {
        // you pick a hard-coded, randomly chosen, non-zero, odd number
        // ideally different for each class
        return new HashCodeBuilder(29, 29).
                append(fields).
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
        
        SudokuPart rhs = (SudokuPart) obj;
        return new EqualsBuilder()
                //.appendSuper(super.equals(obj))
                .append(fields, rhs.fields)
                      .isEquals();
    }
    
    public String toString() {
        return new ToStringBuilder(this).
                append("fields", fields).
          toString();
    }
    //only for cloneable tests
    SudokuField getField(int i) {
        return fields.get(i);
    }

    void setField(int i, final SudokuField newField) {
        fields.set(i, newField);
    }

}
