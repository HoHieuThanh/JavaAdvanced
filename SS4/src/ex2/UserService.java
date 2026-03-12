package ex2;

public class UserService {

    public boolean checkRegistrationAge(int age) {

        if (age < 0) {
            throw new IllegalArgumentException("Tuổi không hợp lệ");
        }

        return age >= 18;
    }
}
