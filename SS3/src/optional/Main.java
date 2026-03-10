package optional;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Optional<Integer> optional = Optional.empty();
        Optional<Integer> optional1 = Optional.of(1);
        Optional<Integer> optional2 = Optional.ofNullable(2);

        // Kiểm tra khác null
        if (optional2.isPresent()){
            System.out.println(optional2.get());
        }

        // Lấy giá trị
        Integer value = optional2.orElse(100);
        System.out.println(value);

        // Lấy trực tiếp giấ trị hoặc ném ngoại lệ
        Integer i = optional2.orElseThrow(() -> new RuntimeException("Lỗi"));

        List<Integer> randomList = Stream.generate(() -> new Random().nextInt(10))
                .limit(10)
                .toList();
        System.out.println(randomList);

        // Tìm max
        Integer max =  randomList.stream().max(Integer::compareTo)
                .orElse(Integer.MIN_VALUE);
        System.out.println(max);

        // Tìm số đầu tiên chia hết cho 3
        Integer find =  randomList.stream().filter(integer -> integer%3==0)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Không có"));
        System.out.println(find);
    }
}
