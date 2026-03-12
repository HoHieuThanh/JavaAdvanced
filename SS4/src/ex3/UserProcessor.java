package ex3;

public class UserProcessor {

    public String processEmail(String email) {

        if (email == null) {
            throw new IllegalArgumentException("Email không hợp lệ");
        }

        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email phải chứa @");
        }

        String[] parts = email.split("@");

        if (parts.length != 2 || parts[1].isEmpty()) {
            throw new IllegalArgumentException("Email phải có tên miền");
        }

        return email.toLowerCase();
    }
}
