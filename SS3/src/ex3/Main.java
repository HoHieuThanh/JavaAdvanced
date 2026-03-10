package ex3;

public class Main {

    public static void main(String[] args) {

        UserRepository repo = new UserRepository();

        repo.findUserByUsername("alice")
                .ifPresentOrElse(
                        u -> System.out.println("Welcome " + u.name()),
                        () -> System.out.println("Guest login")
                );
    }
}

