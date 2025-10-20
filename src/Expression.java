import java.util.Map;

//Base class for all expressions
public interface Expression {
    Object interpret (Map<String, Object> environment);
}
