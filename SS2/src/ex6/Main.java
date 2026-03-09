package ex6;

public class Main {

    public static void main(String[] args) {

        User user = new User("alice");

        // Method Reference tới static method
        UserProcessor processor = UserUtils::convertToUpperCase;

        String result = processor.process(user);

        System.out.println(result);
    }
}
