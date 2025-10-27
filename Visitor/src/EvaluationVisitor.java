import java.util.Map;

// Evaluation Visitor
public class EvaluationVisitor implements ExpressionVisitor<Object> {

    private final Map<String, Object> environment;

    public EvaluationVisitor(Map<String, Object> environment) {

        this.environment = environment;
    }

    @Override
    public Object visit(NumberLiteral number) {
       return number.getValue();
    }

    @Override
    public Object visit(BooleanLiteral bool) {
        return bool.getValue();
    }

    @Override
    public Object visit(Variable variable) {
        String name = variable.getName();
        if (!environment.containsKey(name)) {
            throw new RuntimeException("Unbound␣ variable : ␣" + name);
        }
        return environment.get(name);
    }

    @Override
    public Object visit(BinaryOperation binOp) {
        Object leftVal = binOp.getLeft().accept(this);
        Object rightVal = binOp.getRight().accept(this);
        String operator = binOp.getOperator();
        switch (operator) {
            case "+":
                return handleAddition(leftVal, rightVal);
            case "−":
                return handleSubtraction(leftVal, rightVal);
            case "∗":
                return handleMultiplication(leftVal, rightVal);
            case "/":
                return handleDivision(leftVal, rightVal);
            case "&&":
                return handleLogicalAnd(leftVal, rightVal);
            case " | | ":
                return handleLogicalOr(leftVal, rightVal);
            case "<":
                return handleLessThan(leftVal, rightVal);
            case ">":
                return handleGreaterThan(leftVal, rightVal);
            case "==":
                return handleEquals(leftVal, rightVal);
            default:
                throw new RuntimeException("Unknown␣operator : ␣" + operator);
        }
    }

    @Override
    public Object visit(UnaryOperation unOp) {
        Object operandVal = unOp.getOperand().accept(this);
        String operator = unOp.getOperator();
        switch (operator) {
            case " ! ":
                if (operandVal instanceof Boolean) {
                    return !(Boolean) operandVal;
                }
                throw new RuntimeException("Type␣mismatch␣ for ␣ ! : ␣operand␣must␣be␣ boolean");
            default:
                throw new RuntimeException("Unknown␣unary␣operator : ␣" + operator);
        }
    }

    @Override
    public Object visit(Conditional conditional) {
        Object condVal = conditional.getCondition().accept(this);
        if (condVal instanceof Boolean) {
            if ((Boolean) condVal) {
                return conditional.getThenBranch().accept(this);
            } else {
                return conditional.getElseBranch().accept(this);
            }
        }
        throw new RuntimeException("Condition␣must␣evaluate␣to␣boolean");
    }

    // Helper methods for binary operations
    private Object handleAddition(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return (Integer) left + (Integer) right;
        }
        throw new RuntimeException("Type␣mismatch␣ for ␣+:␣both␣operands␣must␣be␣ integers ");
    }

    private Object handleSubtraction(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return (Integer) left - (Integer) right;
        }
        throw new RuntimeException("Type␣mismatch␣ for ␣−:␣both␣operands␣must␣be␣ integers ");
    }

    private Object handleMultiplication(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return (Integer) left  *(Integer) right;
        }
        throw new RuntimeException("Type␣mismatch␣ for ␣∗:␣both␣operands␣must␣be␣ integers ");
    }

    private Object handleDivision(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            if ((Integer) right == 0) {
                throw new RuntimeException("Division␣by␣zero");
            }
            return (Integer) left / (Integer) right;
        }
        throw new RuntimeException("Type␣mismatch␣ for ␣/:␣both␣operands␣must␣be␣ integers ");
    }

    private Object handleLogicalAnd(Object left, Object right) {
        if (left instanceof Boolean && right instanceof Boolean) {
            return (Boolean) left && (Boolean) right;
        }
        throw new RuntimeException("Type␣mismatch␣ for ␣&&:␣both␣operands␣must␣be␣ booleans");
    }

    private Object handleLogicalOr(Object left, Object right) {
        if (left instanceof Boolean && right instanceof Boolean) {
            return (Boolean) left || (Boolean) right;
        }
        throw new RuntimeException("Type␣mismatch␣ for ␣ | | : ␣both␣operands␣must␣be␣ booleans");
    }

    private Object handleLessThan(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return (Integer) left < (Integer) right;
        }
        throw new RuntimeException("Type␣mismatch␣ for ␣<:␣both␣operands␣must␣be␣ integers ");
    }

    private Object handleGreaterThan(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return (Integer) left > (Integer) right;
        }
        throw new RuntimeException("Type␣mismatch␣ for ␣>:␣both␣operands␣must␣be␣ integers ");
    }

    private Object handleEquals(Object left, Object right) {
        if (left.getClass().equals(right.getClass())) {
            return left.equals(right);
        }
        throw new RuntimeException("Type␣mismatch␣ for ␣==:␣operands␣must␣be␣of␣same␣ type");
    }
}
