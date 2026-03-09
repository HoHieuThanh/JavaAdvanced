package ex2;
@FunctionalInterface
public interface PasswordValidator {
    boolean isValid(String password);
}
