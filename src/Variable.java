import java.util.Map;

public class Variable implements Expression {

    private final String name;

    public Variable(String name) {
        this.name = name;
    }
    @Override
    public Object interpret(Map<String, Object> environment){
        if (!environment.containsKey(name)){
            throw new RuntimeException("Unbound variable: " + name);
        }
        return environment.get(name);
    }

}
