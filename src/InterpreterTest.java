import java.util.HashMap;
import java.util.Map;

public class InterpreterTest {
    public static void main(String[] args) {
        IO.println(String.format("Hello and welcome!"));

        //Create environemnt : x = -10, y = 20, flag = true
        Map<String, Object> env = Map.of(
                "x", 10,
                "y", 20,
                "flag", true
        );

        NumberLiteral  test = new NumberLiteral(5);
        BooleanLiteral bool = new BooleanLiteral(true);
        Variable       var  = new Variable("x");

        BinaryOperation x = new BinaryOperation(test, "+", test);

        // Test expression :	i f	flag	then x + y	else x − y
        Expression testExpr =
                new Conditional(new Variable("flag"),
                    new BinaryOperation(new Variable("x"), "+", new Variable("y")),
                        new BinaryOperation(new Variable("x"), "-", new Variable("y")));

        // Test both interpreters
        Object result1 = testExpr.interpret(env); // Interpreter pattern
        System.out.println(" Interpreter result : " + result1);


        IO.println(x.interpret(env));

    }
}
