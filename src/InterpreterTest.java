import java.util.HashMap;
import java.util.Map;

public class InterpreterTest {
    public static void main(String[] args) {
        IO.println(String.format("Hello and welcome!"));

        //Create environemnt : x = -10, y = 20, flag = true
        Map<String, Object> env = Map.of(
                "x", 10,
                "y", 20
        );

        NumberLiteral  test = new NumberLiteral(5);
        BooleanLiteral bool = new BooleanLiteral(true);
        Variable       var  = new Variable("x");

        BinaryOperation x = new BinaryOperation(test, "+", test);

        IO.println(x.interpret(env));

    }
}
