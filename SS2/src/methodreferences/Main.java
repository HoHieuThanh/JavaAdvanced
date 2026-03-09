package methodreferences;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // tham chiếu cuả 1 phương thức
        List<String> names = Arrays.asList("Nam", "TRung", "SƠn");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        names.forEach(System.out::println);
        names.forEach(Printer::print);

        List<Student> studentList = names.stream()
                .map(Student::new)
                .toList();

        // Lọc
        studentList.stream().filter(student -> student.getName().contains("h"))
                .sorted((Comparator.comparing(Student::getName)))
                .forEach(System.out::println);

        // 4 phương thức cơ bản map, filter, forEach, reduce
        Random rad = new Random();

        //Supplie
        List<Integer> integers = Stream.generate(()->rad.nextInt(100))
                .limit(20).toList();

        //Consumer
        integers.forEach(System.out::println);

        // Predicate
        integers.stream().filter(a-> a%3==0)
                .forEach(System.out::println);

        //Function
        integers.stream().map(a -> Math.pow(a, 3))
                .forEach(System.out::println);
        long total = integers.stream().reduce(0,(a,b) -> a+b);
        System.out.println(total);
    }
}
