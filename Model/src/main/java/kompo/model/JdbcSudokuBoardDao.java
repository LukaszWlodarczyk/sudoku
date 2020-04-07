package kompo.model;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class JdbcSudokuBoardDao implements Dao<SudokuBoard>, AutoCloseable {

    DB db;
    String tmp = LocalDateTime.now().toString();

    public JdbcSudokuBoardDao() {
        db = new DB();
        db.createNewDatabase();
    }

    @Override
    public SudokuBoard read() {
        SudokuBoard sudokuBoard = new SudokuBoard();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                try {
                    sudokuBoard.set(i, j, db.select("SudokuBoard" + tmp, i, j));
                    //sudokuBoard.set(i, j, db.select("sudokuBoard", i, j));
                } catch (MyException e) {
                    e.printStackTrace();
                }
            }
        }
        return sudokuBoard;
    }

    @Override
    public boolean write(final SudokuBoard sudokuBoard) {
        db.createTable("SudokuBoard" + tmp);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Integer id = i * 9 + j + 1;
                db.insert("sudokuBoard", sudokuBoard.get(i, j), id);
            }
        }
        return true;
    }

    @Override
    public void finalize() throws IOException {
        try {
            //reading.close();
            //writing.close();
        } catch (Exception e) {
            // ...
        }
    }

    @Override
    public void close() throws Exception {
        try {
            //reading.close();
            //writing.close();
        } catch (Exception e) {
            // ...
        }

    }
}
