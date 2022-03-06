// You can experiment here, it won’t be checked

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-1, 0, 1, -2, 2, 3, -4, 5, -6);

        List<Integer> resultList = numbers.stream()
                .filter(n -> n < 4)
                .map(n -> n * n)
                .filter(n -> n < 10)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(resultList);

    }
}
