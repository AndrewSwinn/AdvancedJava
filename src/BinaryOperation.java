import java.util.Map;

public class BinaryOperation implements Expression {

    private final Expression left ;
    private final String operator ;
    private final Expression right ;

    public BinaryOperation(Expression left, String operator, Expression right) {

        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public Object interpret(Map<String, Object> environment){

        Object leftVal = left.interpret(environment) ;
        Object rightVal = right.interpret (environment) ;

        switch (operator) {
            case "+":
                return interpretAddition(leftVal, rightVal);
            default:
                throw new RuntimeException("Unknown␣operator :␣" + operator);
        }
    }

    private Object interpretAddition(Object left, Object right){
        if ( left instanceof Integer && right instanceof Integer) {
                return (Integer) left + (Integer)right ;
        }
        throw new RuntimeException("Type␣mismatch␣for␣+:␣both␣operands␣must␣be␣integers");
        }

}


