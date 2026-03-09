package funtional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        IColorable obj = new Shap();
        obj.draw();
        obj.printColor("Red");
        IColorable.erase();

        IColorable i1 = new Shap();
        IColorable i2 = new IColorable() {
            @Override
            public void printColor(String color) {

            }
        };
        //Lambda: cú pháp viết gọn của 1 method để tạo nhanh đối tượng từ I
        IFunctional ld = () -> {};

        Comparator<Shap> s1 = (c1, c2)-> 1;
        Collections.sort(new ArrayList<>(), (o1, o2) -> 1);

        int[] arr = {1,2,3,4,5};
        Arrays.stream(arr).map(value -> value * 2).forEach(t-> System.out.println(t));
    }
}
