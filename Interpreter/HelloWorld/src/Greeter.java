public class Greeter implements Hello {

    public String hello(String name) {
        return "Hello " + name;
    }

    public String hello(int number) {
        return "Hello " + number;
    }

    public String hello(double number) {
        return "Hello " + number;
    }
}
