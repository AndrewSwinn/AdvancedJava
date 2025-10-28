import java.util.Set;
import java.util.HashSet;

public class VariableCollector implements ExpressionVisitor<Object> {

    private final Set<String> collection = new HashSet<>();

    public Set<String>  getCollection() {
        return new HashSet<>(collection);
    }
    @Override
    public Object visit(NumberLiteral number){return null;}

    @Override
    public Object visit(BooleanLiteral bool) {return null;}

    @Override
    public Object visit(Variable variable) {
        collection.add(variable.getName());
        return null;}

    @Override
    public Object visit(BinaryOperation binOp) {
        Object left  = binOp.getLeft().accept(this);
        Object right = binOp.getRight().accept(this);
        return null;
    }

    @Override
    public Object visit(UnaryOperation unOp) {
        Object flag = unOp.getOperand().accept(this);
        return null;
    }

    @Override
    public Object visit(Conditional conditional) {
        Object condition = conditional.getCondition().accept(this);
        Object Then      = conditional.getThenBranch().accept(this);
        Object Else      = conditional.getElseBranch().accept(this);
        return null;
    }

}
