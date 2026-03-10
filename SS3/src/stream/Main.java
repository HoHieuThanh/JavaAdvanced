package stream;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (Integer value: list){
            if (value == 2){
                list.remove(value);
            }
        }
        System.out.println(list);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            if (iterator.next() == 1){
                iterator.remove();
            }
        }
        System.out.println(list);

        // Tạo Stream: Arrays và Collection
        int[] arr = {1,2,3,4,5};
        IntStream streamInt = Arrays.stream(arr);
        Stream<Integer> stream2 = list.stream();

        // Thao tác trung gian trả về 1 stream mới: sorted, limit, distinct, filter, map,...
        IntStream stream3 = streamInt.filter(value -> value%2==0);

        // Thao tác đầu cuối
        OptionalDouble avg = stream3.average();

        // Tạo list 1000 số nn từ -200 đến 200
        List<Integer> randomList = Stream.generate(() -> new Random().nextInt(400)-200)
                .limit(100)
                .toList();

        // 1. Lọc và in các số nguyên dương
        randomList.stream().filter(v -> v>0)
                .forEach(integer -> System.out.print(integer + " "));

        // 2. Loại bỏ các số trùng
        List<Integer> distinctList = randomList.stream().distinct().toList();
        System.out.println("\n" + distinctList);

        // 3. Săp xếp giảm dần
        randomList.stream().sorted(Comparator.reverseOrder())
                .forEach(integer -> System.out.print(integer + " "));

        // 4. Tính min max
        Integer min = randomList.stream().min(Comparator.comparingInt(o -> o)).get();
        Integer max = randomList.stream().max(Comparator.comparingInt(o -> o)).get();
        System.out.println("\nMin: " + min);
        System.out.println("Max: " + max);

        // 5. Tính tổng
        Integer sum = randomList.stream().reduce(0, (Integer::sum));
        System.out.println("Sum: "+ sum);

        // 6. Kiểm tra giá tri n nhập vào có tồn tại ko
        boolean isExits = randomList.stream().anyMatch(integer -> integer == 100);
        System.out.println("100: " + isExits);

        // 7. Chuyển số âm thành số đối
        List<Integer> mapInt = randomList.stream().map(integer -> integer<0 ? -integer: integer).toList();
        System.out.println(mapInt);

    }
}
