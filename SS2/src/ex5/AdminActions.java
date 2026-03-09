package ex5;

public interface AdminActions {

    default void logActivity(String activity) {
        System.out.println("[Admin Log] " + activity);
    }
}
