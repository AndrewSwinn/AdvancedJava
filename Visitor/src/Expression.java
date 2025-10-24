// Base AST node with accept method
public abstract class Expression {
    public abstract <T> T accept(ExpressionVisitor<T> visitor);
}
