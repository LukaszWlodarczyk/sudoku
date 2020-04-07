package kompo.model;
import java.io.FileNotFoundException;

public interface Dao<T> extends AutoCloseable {

    public T read() throws FileNotFoundException;
    
    public boolean write(T obj) throws FileNotFoundException;    
}
