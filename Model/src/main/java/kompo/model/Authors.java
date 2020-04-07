package kompo.model;

import java.util.ListResourceBundle;

public class Authors extends ListResourceBundle {
    @Override
    public Object[][] getContents() {
        return contents;
    }
    private Object[][] contents = {
            {"author1", "Mateusz Zawisza"},
            {"author2", "Lukasz Wlodarczyk"}
    };
}