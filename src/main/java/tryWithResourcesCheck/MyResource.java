package tryWithResourcesCheck;

import java.util.ArrayList;
import java.util.List;

public class MyResource implements AutoCloseable{

    @Override
    public void close() throws Exception {
        List list = new ArrayList();
        list.add("Java");
        list.add(5);

        for(Object obj:list) {
            String str = (String)obj;
        }
    }
}
