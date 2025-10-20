import java.util.Map;

public class BinaryOperations implements Expression {
    public BinaryOperations() {

    }

    @Override
    public Object interpret(Map<String, Object> environment){

        NumberLiteral a = (NumberLiteral) environment.get("a");

        return a;


    }

}
