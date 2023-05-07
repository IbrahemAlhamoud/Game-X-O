import java.util.List;
import java.util.Map;

public interface iteratorManager {

    boolean hasNext();

    Map<String,Object> getNext();

    void reset();
}
