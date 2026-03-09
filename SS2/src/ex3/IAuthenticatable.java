package ex3;

@FunctionalInterface
public interface IAuthenticatable {

    // Phương thức trừu tượng
    String getPassword();

    // Default method
    default boolean isAuthenticated() {
        return getPassword() != null && !getPassword().isEmpty();
    }

    // Static method
    static String encrypt(String rawPassword) {
        return "ENC_" + rawPassword;
    }
}
