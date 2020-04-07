package kompo.model;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SudokuField implements Cloneable, Comparable<SudokuField> {
    
    private int value = 0;
    
    SudokuField() {
        value = 0;
    }
    SudokuField(int value) {
        this.value = value;
    }
    
    int getFieldValue() {
        return value;
    }
    
    void setFieldValue(int value) {
        this.value = value;
    }
    
    public int hashCode() {
        // you pick a hard-coded, randomly chosen, non-zero, odd number
        // ideally different for each class
        return new HashCodeBuilder(29, 17).
                append(value).
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
        
        SudokuField rhs = (SudokuField) obj;
        return new EqualsBuilder()
                //.appendSuper(super.equals(obj))
                .append(value, rhs.value)
                      .isEquals();
    }
    
    public String toString() {
        return new ToStringBuilder(this).
                append("value", value).
          toString();
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int compareTo(final SudokuField field) {

        int compTmp;

        if (value > field.value) {
            compTmp = 1;
        } else if (value < field.value) {
            compTmp = -1;
        } else {
            compTmp = 0;
        }

        return compTmp;

    }
}
