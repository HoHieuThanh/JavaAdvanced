package ex6;

import java.time.LocalDate;
import java.util.List;

public class UserService {

    public User updateProfile(User existingUser,
                              UserProfile newProfile,
                              List<User> allUsers) {

        // kiểm tra ngày sinh trong tương lai
        if (newProfile.getBirthDate().isAfter(LocalDate.now())) {
            return null;
        }

        String newEmail = newProfile.getEmail();

        // kiểm tra email trùng với user khác
        if (allUsers != null) {
            for (User u : allUsers) {
                if (u != existingUser &&
                        u.getEmail().equalsIgnoreCase(newEmail)) {
                    return null;
                }
            }
        }

        // cập nhật hồ sơ
        existingUser.setEmail(newEmail);
        existingUser.setBirthDate(newProfile.getBirthDate());

        return existingUser;
    }
}
