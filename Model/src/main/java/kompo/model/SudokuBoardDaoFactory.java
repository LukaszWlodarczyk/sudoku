package kompo.model;


public class SudokuBoardDaoFactory {
    
    public Dao<SudokuBoard> getFileDao(final String fileName) throws Exception {

        FileSudokuBoardDao fileSudokuBoardDao = new FileSudokuBoardDao(fileName);
        return fileSudokuBoardDao;
    }

    public Dao<SudokuBoard> getDatabaseDao() throws Exception {

        JdbcSudokuBoardDao jdbcSudokuBoardDao = new JdbcSudokuBoardDao();
        return jdbcSudokuBoardDao;
    }

}
