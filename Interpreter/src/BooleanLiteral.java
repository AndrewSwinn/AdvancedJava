import java.util.Map;

public class BooleanLiteral implements Expression {

    private final boolean value;

    public BooleanLiteral(boolean value) {
        this.value = value;
    }

    @Override
    public Object interpret(Map<String, Object> environment) {
        return value;
    }
}


