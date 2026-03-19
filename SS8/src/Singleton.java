public class Singleton {
    public static void main(String[] args) {
        StudentMenu instance  = StudentMenu.getInstance();
        instance.printMenu();
    }
}
class StudentMenu{
    // thuộc tính tĩnh
    private static StudentMenu instance;

    // pt khởi tạo là private
    private StudentMenu(){
    }

    public static StudentMenu getInstance(){
        if (instance ==null){
            instance = new StudentMenu();
        }
        return instance;
    }
    public void printMenu(){

    }
}
