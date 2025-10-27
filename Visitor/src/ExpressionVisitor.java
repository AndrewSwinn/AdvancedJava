// Visitor interface
public interface ExpressionVisitor<T> {
    T visit(NumberLiteral number);

    T visit(BooleanLiteral bool);

    T visit(Variable variable);

    T visit(BinaryOperation binOp);

    T visit(UnaryOperation unOp);

    T visit(Conditional conditional);
}
