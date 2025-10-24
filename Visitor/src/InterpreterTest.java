import java.util.Map;

public class InterpreterTest {
    public static void main(String[] args) {

// Create environment : x = −10, y = 20 ,
        Map<String, Object> env = Map.of(
                "x", 10,
                "y", 20,
                "flag", true
        );
        // Test expression :	i f	flag	then x + y	else x − y
        Expression testExpr = new Conditional(new Variable("flag"),
                new BinaryOperation(new Variable("x"), "+", new Variable("y")),
                    new BinaryOperation(new Variable("x"), "−", new  Variable("y")));


        EvaluationVisitor visitor = new EvaluationVisitor(env);

        Object result2 = testExpr.accept(visitor); // Visitor pattern

        System.out.println(" Visitor result : " + result2);

    }
}
