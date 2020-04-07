package kompo.model;

public class Level {

    protected int fieldsToRemove;
    public Level(int amountOfFields) {
        fieldsToRemove = amountOfFields;
    }
    public void removeFields(final SudokuBoard sBoard) {
        for (int i = 0; i < fieldsToRemove; i++) {
            int x = (int) (Math.random() * 9);
            int y = (int) (Math.random() * 9);
            if (sBoard.get(x, y) != 0) {
                sBoard.set(x, y, 0);
            } else {
                i--;
            }
        }
    }
}

