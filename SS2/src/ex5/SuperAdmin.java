package ex5;

public class SuperAdmin implements UserActions, AdminActions {

    @Override
    public void logActivity(String activity) {

        // chọn log của Admin
        AdminActions.super.logActivity(activity);

        // hoặc có thể gọi cả hai
        // UserActions.super.logActivity(activity);
    }
}
