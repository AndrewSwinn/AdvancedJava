import java.util.Map;

public class InterpreterTest {

    public static void main(String[] args) {

// Create environment : x = −10, y = 20 ,
        Map<String, Object> env = Map.of(
                "x", 10,
                "y", 20,
                "z", 30,
                "flag", true
        );
        // Test expression :	i f	flag	then x + y	else x − y
        Expression testExpr = new Conditional(new Variable("flag"),
                new BinaryOperation(new Variable("x"), "+", new Variable("y")),
                    new BinaryOperation(new Variable("x"), "−", new  Variable("y")));

        NumberLiteral    five =  new NumberLiteral(5);
        Variable         abc  = new Variable("abc");
        BooleanLiteral   TRUE = new BooleanLiteral(true);
        BinaryOperation binOp = new BinaryOperation(new Variable("x"), "−", new  Variable("y"));
        UnaryOperation  unOp  = new UnaryOperation("!", new Variable("flag") );


        EvaluationVisitor visitor = new EvaluationVisitor(env);
        VariableCollector collector = new VariableCollector();

        Object result1 = five.accept(visitor);
        Object result2 = testExpr.accept(visitor);

        Object collect = testExpr.accept(collector);

        System.out.println(" Visitor result1 : " + result1);
        System.out.println(" Visitor result2 : " + result2);
        System.out.println(" Collector result2 : " + collector.getCollection());

    }
}
