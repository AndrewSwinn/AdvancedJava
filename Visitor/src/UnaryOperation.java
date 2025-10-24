public class UnaryOperation extends Expression {
    private final String operator;
    private final Expression operand;

    public UnaryOperation(String operator, Expression operand) {
        this.operator = operator;
        this.operand = operand;
    }

    public String getOperator() {
        return operator;
    }

    public Expression getOperand() {
        return operand;
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
