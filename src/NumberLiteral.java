import java.util.Map;

public class NumberLiteral implements Expression {
    private final int value;

    public NumberLiteral(int value) {
        this.value = value;
    }

    @Override
    public Object interpret(Map<String, Object>  environment) {
        return value;
    }
}
