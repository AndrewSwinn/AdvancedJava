public class Tester {
    public static void main(String[] args) {

        System.out.println(String.format("Hello and welcome!"));

        Greeter friend = new Greeter();
        System.out.println(friend.hello("Andrew"));
        System.out.println(friend.hello(12));
        System.out.println(friend.hello(12.5));
        for (int i = 1; i <= 5; i++) {

            System.out.println("i = " + i);
        }
    }
}
