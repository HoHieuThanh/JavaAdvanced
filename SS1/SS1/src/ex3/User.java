package ex3;

import ex5.InvalidAgeException;

public class User {

    private String name;
    private int age;

    public void setName(String name) {

        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Tên không hợp lệ!");
        }
    }

    public void setAge(int age) throws InvalidAgeException {

        if (age < 0) {
            throw new InvalidAgeException("Tuổi không thể âm!");
        }

        this.age = age;
    }

    public void display() {

        if (name != null) {
            System.out.println("Tên: " + name);
        } else {
            System.out.println("Tên chưa được thiết lập");
        }

        System.out.println("Tuổi: " + age);
    }
}
