import java.util.Map;

public class Conditional implements Expression {
    private final Expression condition;
    private final Expression thenBranch;
    private final Expression elseBranch;

    public Conditional(Expression condition, Expression thenBranch, Expression elseBranch) {
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }

    @Override
    public Object interpret(Map<String, Object> environment) {
        Object condVal = condition.interpret(environment);
        if (condVal instanceof Boolean) {
            if ((Boolean) condVal) {
                return thenBranch.interpret(environment);
            } else {
                return elseBranch.interpret(environment);
            }
        }
        throw new RuntimeException("Condition␣must␣evaluate␣to␣boolean");
    }

    public Expression getCondition() {
        return condition;
    }

    public Expression getThenBranch() {
        return thenBranch;
    }

    public Expression getElseBranch() {
        return elseBranch;
    }
}
